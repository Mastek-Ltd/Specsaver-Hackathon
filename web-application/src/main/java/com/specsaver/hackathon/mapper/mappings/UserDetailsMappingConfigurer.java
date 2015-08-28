package com.specsaver.hackathon.mapper.mappings;

import ma.glasnost.orika.MapperFactory;

import org.springframework.stereotype.Component;

import com.specsaver.hackathon.domain.LoginDetails;
import com.specsaver.hackathon.entities.UserMaster;
import com.specsaver.hackathon.mapper.config.MappingConfigurer;

/**
 * Converter for user details objects.
 * @author Krishna Kuntala
 */
@Component
public class UserDetailsMappingConfigurer implements MappingConfigurer
{

	/*
	 * (non-Javadoc)
	 * @see
	 * uk.gov.hscic.careid.identity.mapper.common.MappingConfigurer#configure
	 * (ma.glasnost.orika.MapperFactory)
	 */
	@Override
	public void configure(MapperFactory factory)
	{
		factory.classMap(LoginDetails.class, UserMaster.class).field("loggedInTime", "lastLoggedInTime").byDefault().register();
	}
}