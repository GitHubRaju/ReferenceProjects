package com.mvc;

import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	/*
	 * public void
	 * configureDefaultServletHandling(DefaultServletHandlerConfigurer handler)
	 * { handler.enable(); }
	 */
	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}

	/**
	 * Register dispatcherServlet programmatically
	 *
	 * @return ServletRegistrationBean
	 */
	@Bean
	public ServletRegistrationBean dispatcherServletRegistration() {

		ServletRegistrationBean registration = new ServletRegistrationBean(
				dispatcherServlet(), "/");
		registration.setLoadOnStartup(1);

		registration
				.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);

		return registration;
	}

	@Bean
	public InternalResourceViewResolver vewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	 @Override//it is to load default page(wecome page)
	  public void addViewControllers(ViewControllerRegistry registry) {
	   // registry.addViewController("/").setViewName("index");
		 registry.addRedirectViewController("/", "index");
	  }
}
