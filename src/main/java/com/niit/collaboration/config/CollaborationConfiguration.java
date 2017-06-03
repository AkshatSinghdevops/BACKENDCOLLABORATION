package com.niit.collaboration.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.niit.collaboration.backendcontroller,com.niit.collaboration.model,com.niit.collaboration.daoimpl,com.niit.collaboration.dao,com.niit.collaboration.config")
public class CollaborationConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry)
{
		
	InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
viewResolver.setViewClass(JstlView.class);
viewResolver.setPrefix("/WEB-INF/view/");
viewResolver.setSuffix(".jsp");
registry.viewResolver(viewResolver);
}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry  registry)
	{
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
}
