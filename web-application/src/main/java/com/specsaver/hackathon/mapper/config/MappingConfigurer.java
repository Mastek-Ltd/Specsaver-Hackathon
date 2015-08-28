package com.specsaver.hackathon.mapper.config;

import ma.glasnost.orika.MapperFactory;

/**
 * The Interface MappingConfigurer.
 */
public interface MappingConfigurer
{

	/**
	 * Configure Mapper Factory.
	 * @param factory the Mapper factory
	 */
	void configure(MapperFactory factory);
}
