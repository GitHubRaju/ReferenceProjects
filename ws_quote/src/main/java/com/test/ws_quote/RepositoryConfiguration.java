package com.test.ws_quote;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jbhunt.lib_quote_entity.QuoteRequest;
import com.jbhunt.lib_quote_entity.QuoteRequestItemClass;
import com.jbhunt.lib_quote_entity.QuoteStop;

/**
 * Repository configuration for reference data entities
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.jbhunt.ws_quote")
@EnableTransactionManagement
public class RepositoryConfiguration extends RepositoryRestMvcConfiguration {

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(QuoteRequest.class);
        config.exposeIdsFor(QuoteRequestItemClass.class);
        config.exposeIdsFor(QuoteStop.class);
      
    }

}
