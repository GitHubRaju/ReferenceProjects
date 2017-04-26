package com.test.ws_quote.route;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class QuoteRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:postToTopic").marshal().json(JsonLibrary.Jackson).log("Quote Router : Quote Posted to Topic").to("activemqProducer:topic:ORDER.T.CAPTURE.QUOTE.UPDATE.EVENT").end();
		
	}

	

}
