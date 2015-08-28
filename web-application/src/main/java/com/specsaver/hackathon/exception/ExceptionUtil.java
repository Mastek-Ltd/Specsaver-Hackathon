package com.specsaver.hackathon.exception;

import uk.gov.hscic.framework.context.ContextInfo;
import uk.gov.hscic.framework.exceptionmanager.CareIDException;
import uk.gov.hscic.framework.exceptionmanager.ExceptionManager;
import uk.gov.hscic.framework.exceptionmanager.impl.CareIDExceptionImpl;
import uk.gov.hscic.framework.exceptionmanager.impl.CareIDSystemExceptionImpl;
import uk.gov.hscic.framework.exceptionmanager.impl.ExceptionManagerImpl;
import uk.gov.hscic.framework.exceptionmanager.impl.ExceptionManagerImpl.Severity;

public final class ExceptionUtil {

	private static ExceptionManager exceptionManager = ExceptionManagerImpl.getExceptionManager();

	private ExceptionUtil() {
	}

	public static CareIDExceptionImpl createException(String exceptionId, Severity severity, CareIDExceptionImpl exception, ContextInfo contextInfo, boolean printStackTrace, Object[] param) {
		logException(severity, contextInfo, printStackTrace, exception);
		return exception;
	}

	public static CareIDSystemExceptionImpl createException(String exceptionId, Severity severity, CareIDSystemExceptionImpl exception, ContextInfo contextInfo, boolean printStackTrace, Object[] param) {
		logException(severity, contextInfo, printStackTrace, exception);
		return exception;
	}

	public static void logException(Severity severity, ContextInfo contextInfo, boolean printStackTrace, CareIDException exception) {
		exceptionManager.logErrorEvent(exception, contextInfo, severity, printStackTrace);
	}
}