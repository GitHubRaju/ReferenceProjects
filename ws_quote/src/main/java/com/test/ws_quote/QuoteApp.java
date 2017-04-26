package com.test.ws_quote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EntityScan(basePackages="com.jbhunt.lib_quote_entity")
public class QuoteApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(QuoteApp.class, args);
    }
}
