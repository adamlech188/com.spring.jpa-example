package com.spring.data.main;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class DataJPAExampleInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ApplicationContext.class);
		ContextLoaderListener listener = new ContextLoaderListener(rootContext); 
		servletContext.addListener(listener);
		

		DispatcherServlet dispatcherServler = new DispatcherServlet(rootContext);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServler);
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		
	}

}
