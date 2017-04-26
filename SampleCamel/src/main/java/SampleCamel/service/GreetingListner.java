package SampleCamel.service;

import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import SampleCamel.dto.Greeting;

@Component("greetingListner")
public class GreetingListner {
	private static final String SIMPLE_QUEUE = "SAMPLE_QUEUE";
	@Autowired
	private ConsumerTemplate consumerTemplate;
	@Autowired
	private ProducerTemplate producerTemplate;
	//@JmsListener(destination = "SIMPLE_QUEUE")  
    public void receiveQueue(Greeting greeting) {  
        //System.out.println(text);  
   /*Exchange e =consumerTemplate.receive(SIMPLE_QUEUE);
   System.out.println(e.getIn().getBody().toString());*/
    	System.out.println("Queue Recive");
    	if(greeting!=null){
    	System.out.println(greeting.getMsg() +"  "+ greeting.toString());
    	}
    producerTemplate.sendBody("direct:msgExchange",greeting);
    }  
}
