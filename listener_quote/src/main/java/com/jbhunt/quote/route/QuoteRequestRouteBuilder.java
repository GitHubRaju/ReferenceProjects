package com.jbhunt.quote.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.hibernate.validator.internal.util.privilegedactions.Unmarshal;
import org.springframework.stereotype.Component;

import com.test.quote.dto.QuoteRequestDTO;

@Component
public class QuoteRequestRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
	
		from("activeMQConsumer:queue:SUB.QUTOE.UPDATE.ORDER.T.CAPTURE.QUOTE.UPDATE.EVENT").unmarshal().json(JsonLibrary.Jackson, QuoteRequestDTO.class).log("Quote :${body}").to("bean:quoteRequestService?method=quoteRequestToQualification").end();
	}

}
