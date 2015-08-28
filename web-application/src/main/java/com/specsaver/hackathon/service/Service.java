package com.specsaver.hackathon.service;

import ma.glasnost.orika.MapperFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import uk.gov.hscic.framework.exceptionmanager.impl.CareIDExceptionImpl;

import com.specsaver.hackathon.domain.LoginDetails;
import com.specsaver.hackathon.entities.UserMaster;
import com.specsaver.hackathon.web.dao.generic.GenericDAOImpl;

@Component
public class Service
{

	@Autowired
	private MapperFacade						mapperFacade;

	@Autowired
	private GenericDAOImpl<UserMaster>	userDAO;

	@Transactional(rollbackFor = { Exception.class})
	public LoginDetails saveUserLoginDetails(final LoginDetails loginDetails) throws CareIDExceptionImpl
	{
		UserMaster userMaster = userDAO.findByPrimaryKey(loginDetails.getUserUUID());
		if (null != userMaster)
		{
			userMaster = mapperFacade.map(loginDetails, UserMaster.class);
			userDAO.update(userMaster);
		}
		else
		{
			throw new CareIDExceptionImpl("USER_WITH_UUID_NOT_FOUND_EXCEPTION", null, new Object[] { loginDetails.getUserUUID()});
		}
		LoginDetails updatedLoginDetails = mapperFacade.map(userMaster, LoginDetails.class);
		return updatedLoginDetails;
	}

	@Transactional(rollbackFor = { Exception.class})
	public LoginDetails getUserLoginDetails(String userUUID) throws CareIDExceptionImpl
	{
		UserMaster userMaster = userDAO.findByPrimaryKey(userUUID);
		LoginDetails loginDetails = null;
		if (null != userMaster)
		{
			loginDetails = mapperFacade.map(userMaster, LoginDetails.class);
		}
		else
		{
			throw new CareIDExceptionImpl("USER_WITH_UUID_NOT_FOUND_EXCEPTION", null, new Object[] { userUUID});
		}
		return loginDetails;
	}
}