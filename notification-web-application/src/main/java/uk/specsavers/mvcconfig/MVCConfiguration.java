
package uk.specsavers.mvcconfig;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.mustache.MustacheTemplateLoader;
import org.springframework.web.servlet.view.mustache.MustacheViewResolver;




@Configuration
@ComponentScan(basePackages = "uk.specsavers")
@ImportResource({ "classpath:META-INF/spring/applicationcontext.xml"})
@EnableWebMvc
public class MVCConfiguration extends WebMvcConfigurerAdapter
{

	/**
	 * Gets the view resolver.
	 * @param resourceLoader the resource loader
	 * @return the view resolver
	 */
	@Bean
	public ViewResolver getViewResolver(final ResourceLoader resourceLoader)
	{
		final MustacheViewResolver mustacheViewResolver = new MustacheViewResolver();
		mustacheViewResolver.setPrefix("/WEB-INF/page-views/");
		mustacheViewResolver.setSuffix(".html");
		mustacheViewResolver.setCache(false);
		mustacheViewResolver.setContentType("text/html;charset=utf-8");
		final MustacheTemplateLoader mustacheTemplateLoader = new MustacheTemplateLoader();
		mustacheTemplateLoader.setResourceLoader(resourceLoader);
		mustacheViewResolver.setTemplateLoader(mustacheTemplateLoader);
		mustacheViewResolver.setNullValue(StringUtils.EMPTY);
		mustacheViewResolver.setRedirectHttp10Compatible(false);
		return mustacheViewResolver;

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
	 * #addResourceHandlers
	 * (org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
	 * )
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/props/**").addResourceLocations("/props/");
		registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
		registry.addResourceHandler("/plugins/datatables/**").addResourceLocations("/plugins/datatables/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/applet/**").addResourceLocations("/applet/");

	}

}
