package com.specsaver.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uk.gov.hscic.framework.exceptionmanager.impl.CareIDExceptionImpl;
import uk.gov.hscic.framework.exceptionmanager.impl.ExceptionManagerImpl.Severity;
import uk.gov.hscic.framework.logger.service.impl.CareIdDiagnosticLogger;
import uk.gov.hscic.framework.logger.service.impl.CareIdLogFactory;
import uk.gov.hscic.framework.logger.service.impl.CareIdPerformanceLogger;
import uk.gov.hscic.framework.logger.service.impl.CareIdPerformanceLogger.STATUS;

import com.specsaver.hackathon.domain.LoginDetails;
import com.specsaver.hackathon.exception.ExceptionUtil;
import com.specsaver.hackathon.service.Service;

@Controller
@RequestMapping("/login")
public class LoginController
{

	@Autowired
	private Service										service;

	private static final CareIdDiagnosticLogger	DIAGNOSTIC_LOGGER		= CareIdLogFactory.getCareIdDiagnosticLogger(LoginController.class);

	private static final CareIdPerformanceLogger	PERFORMANCE_LOGGER	= CareIdLogFactory.getCareIdPerfLogger(LoginController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView homePage(ModelAndView modelAndView) throws CareIDExceptionImpl
	{
		DIAGNOSTIC_LOGGER.info(STATUS.START.toString(), null, new Object[] { "Get User Login Details"});
		PERFORMANCE_LOGGER.perf(STATUS.START, null);
		modelAndView.setViewName("home_page");
		PERFORMANCE_LOGGER.perf(STATUS.END, null);
		DIAGNOSTIC_LOGGER.info(STATUS.END.toString(), null, new Object[] { "Get User Login Details"});
		return modelAndView;
	}

	@RequestMapping(value = "/loginDetails", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getUserLoginDetails(ModelAndView modelAndView) throws CareIDExceptionImpl
	{
		DIAGNOSTIC_LOGGER.info(STATUS.START.toString(), null, new Object[] { "Get User Login Details"});
		PERFORMANCE_LOGGER.perf(STATUS.START, null);
		modelAndView.setViewName("login_info");
		PERFORMANCE_LOGGER.perf(STATUS.END, null);
		DIAGNOSTIC_LOGGER.info(STATUS.END.toString(), null, new Object[] { "Get User Login Details"});
		return modelAndView;
	}

	@RequestMapping(value = "/loginDetails", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView getUserLoginDetails(@ModelAttribute LoginDetails requestLoginDetails, ModelAndView modelAndView) throws CareIDExceptionImpl
	{
		DIAGNOSTIC_LOGGER.info(STATUS.START.toString(), null, new Object[] { "Save User Login Details"});
		PERFORMANCE_LOGGER.perf(STATUS.START, null);
		LoginDetails loginDetails = null;
		try
		{
			loginDetails = service.getUserLoginDetails(requestLoginDetails.getUserUUID());
			modelAndView.addObject("loginDetails", loginDetails);
		}
		catch (Exception e)
		{
			ExceptionUtil.createException("The user does not exists in the system.", Severity.Error, new CareIDExceptionImpl(e), null, true, null);
			modelAndView.addObject("loginDetails", requestLoginDetails);
			modelAndView.addObject("message", "The user does not exists in the system.");
		}
		modelAndView.setViewName("login_info");
		PERFORMANCE_LOGGER.perf(STATUS.END, null);
		DIAGNOSTIC_LOGGER.info("The saved user login details: " + loginDetails);
		DIAGNOSTIC_LOGGER.error(STATUS.END.toString(), null, new Object[] { "Save User Login Details"});
		return modelAndView;
	}

	@RequestMapping(value = "/saveLoginDetails", method = RequestMethod.GET)
	public ModelAndView saveUserLoginDetails(ModelAndView modelAndView) throws CareIDExceptionImpl
	{
		DIAGNOSTIC_LOGGER.info(STATUS.START.toString(), null, new Object[] { "Save User Login Details"});
		PERFORMANCE_LOGGER.perf(STATUS.START, null);
		modelAndView.setViewName("update_login_info");
		PERFORMANCE_LOGGER.perf(STATUS.END, null);
		DIAGNOSTIC_LOGGER.error(STATUS.END.toString(), null, new Object[] { "Save User Login Details"});
		return modelAndView;
	}

	@RequestMapping(value = "/saveLoginDetails", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView saveUserLoginDetails(@ModelAttribute LoginDetails requestLoginDetails, ModelAndView modelAndView) throws CareIDExceptionImpl
	{
		DIAGNOSTIC_LOGGER.info(STATUS.START.toString(), null, new Object[] { "Save User Login Details"});
		PERFORMANCE_LOGGER.perf(STATUS.START, null);
		LoginDetails loginDetails = null;
		try
		{
			loginDetails = service.saveUserLoginDetails(requestLoginDetails);
			modelAndView.addObject("loginDetails", loginDetails);
		}
		catch (Exception e)
		{
			ExceptionUtil.createException("The user does not exists in the system.", Severity.Error, new CareIDExceptionImpl(e), null, true, null);
			modelAndView.addObject("loginDetails", requestLoginDetails);
			modelAndView.addObject("message", "The user does not exists in the system.");
		}
		modelAndView.setViewName("update_login_info");
		PERFORMANCE_LOGGER.perf(STATUS.END, null);
		DIAGNOSTIC_LOGGER.info("The saved user login details: " + loginDetails);
		DIAGNOSTIC_LOGGER.error(STATUS.END.toString(), null, new Object[] { "Save User Login Details"});
		return modelAndView;
	}
}