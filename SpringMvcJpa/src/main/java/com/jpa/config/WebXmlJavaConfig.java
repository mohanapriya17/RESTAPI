package com.jpa.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebXmlJavaConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	protected Class<?>[] getRootConfigClasses() {
		
		return null;
	}
//this is a servlet
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {ViewResolverConfig.class,DatabaseConfig.class};
	}
//this is a servlet mapping
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
