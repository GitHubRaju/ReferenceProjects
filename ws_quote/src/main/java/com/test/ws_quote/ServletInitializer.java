package com.test.ws_quote;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;



	@SuppressWarnings("deprecation")
	public class ServletInitializer extends SpringBootServletInitializer {

	    /*
	     * (non-Javadoc)
	     * 
	     * @see org.springframework.boot.context.web.SpringBootServletInitializer#
	     * configure(org.springframework.boot.builder.SpringApplicationBuilder)
	     */
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(QuoteApp.class);
	    }

}
