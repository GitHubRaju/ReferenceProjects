package SampleCamel.route;

import java.util.StringJoiner;

import org.apache.camel.RoutingSlip;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import SampleCamel.dto.Greeting;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SampleListnerRoute extends RouteBuilder{
	   
	//from("direct:backPojo").unmarshal().json(JsonLibrary.Jackson, TestPojo.class).to("mock:reversePojo");
		@Override
		public void configure() throws Exception {
			 /*JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
			    jaxbDataFormat.setContextPath(Greeting.class.getPackage().getName());
			    jaxbDataFormat.setFilterNonXmlChars(true);
			*/
			//this will call ruoteslip 
			//from("activemq:queue:SAMPLE_QUEUE").bean(SampleListnerRoute.class, "sampleListenerRouteSlip").end();
		
			
			/*from("direct:orderEnrichment").unmarshal(jaxbDataFormat)
	        .convertBodyTo(Greeting.class).to("bean:greetingListner?method=receiveQueue");
			*/	
			//from("direct:greetings").to("bean:greetingListner?method=receiveQueue");
			from("activemq:queue:SAMPLE_QUEUE").unmarshal().json(JsonLibrary.Jackson, Greeting.class).log("from listner  "+"${body}").to("bean:greetingListner?method=receiveQueue");
		}

		@RoutingSlip
		public String sampleListenerRouteSlip()
		{
			StringJoiner slipBuilder = new StringJoiner(",");		
			slipBuilder.add("direct:greetings");
		
			return slipBuilder.toString();
		
			
		}

}
