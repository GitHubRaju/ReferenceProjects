package com.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableWebMvc
public class MvcApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MvcApp.class, args);

	}
	
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder)
	{
	return builder.sources(MvcApp.class);
	}

}
