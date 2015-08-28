package com.specsaver.hackathon.mapper.config;

import java.util.HashSet;
import java.util.Set;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.specsaver.hackathon.mapper.mappings.UserDetailsMappingConfigurer;

@Component()
public class MapperFacadeFactoryBean implements FactoryBean<MapperFacade>
{
	private final Set<MappingConfigurer>	configurers;

	/**
	 * Instantiates a new mapper facade factory bean.
	 * @param configurers the configurers
	 */
	public MapperFacadeFactoryBean()
	{
		super();
		this.configurers = new HashSet<MappingConfigurer>();
		this.configurers.add(new UserDetailsMappingConfigurer());
	}

	/**
	 * Instantiates a new mapper facade factory bean.
	 * @param configurers the configurers
	 */
	public MapperFacadeFactoryBean(Set<MappingConfigurer> configurers)
	{
		super();
		this.configurers = configurers;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 */
	@SuppressWarnings("deprecation")
	public MapperFacade getObject() throws Exception
	{
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().useBuiltinConverters(true).build();

		for (MappingConfigurer configurer : configurers)
		{
			configurer.configure(mapperFactory);
		}
		mapperFactory.build();
		return mapperFactory.getMapperFacade();
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 */
	public Class<?> getObjectType()
	{
		return MapperFacade.class;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 */
	public boolean isSingleton()
	{
		return true;
	}
}
