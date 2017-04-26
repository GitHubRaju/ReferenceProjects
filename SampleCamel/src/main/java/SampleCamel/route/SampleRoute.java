package SampleCamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import SampleCamel.processor.MyProcessor;




@Component
public class SampleRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		JacksonDataFormat dataFormat=new JacksonDataFormat();
		dataFormat.setAllowJmsType(true);
		
		//parallel processing
		/*from("direct:sendMessage").multicast().parallelProcessing().to("activemq:queue:SAMPLE_QUEUE")
		.to("bean:greetingService?method=printQueue").to("bean:greetingService?method=returnQueue").end();*/
		
		//Sequencial process
		//from("direct:sendMessage").to("activemq:queue:SAMPLE_QUEUE","bean:greetingService?method=returnQueue").end();
		//from("direct:msgExchange").setProperty("msg",simple("${body.getMsg()}")).to("bean:greetingService?method=printQueue").end();
		
		//from("direct:sendMessage").to("bean:greetingService?method=postToTopic").end();
		//from("direct:jsonExchange").to("activemq:queue:SAMPLE_QUEUE").end();
		
		//post the data into Queue/Topic in JSON format
		from("direct:sendMessage").marshal().json(JsonLibrary.Jackson).to("activemq:queue:SAMPLE_QUEUE").end();
		from("direct:msgExchange").process(new MyProcessor()).choice().when(simple("${body.getMsg} contains 'HAA'")).to("bean:greetingService?method=printQueue").end();
		
	}


}
