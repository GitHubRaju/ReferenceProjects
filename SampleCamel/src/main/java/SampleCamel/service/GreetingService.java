package SampleCamel.service;

import javax.transaction.Transactional;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import SampleCamel.dto.Greeting;
import lombok.extern.slf4j.Slf4j;

/*The GreetingServic class is responsible for sending a new Greeiing to the JMS queue.
In order to accomplish this, it uses a JmsTemplate*/
@Slf4j
@Service("greetingService")
public class GreetingService {
	private static final String SIMPLE_QUEUE ="SAMPLE_QUEUE";
	@Autowired
	private ProducerTemplate producerTemplate;
	@Autowired
	private JmsTemplate jsmTemplate;
	
	public void addGreeting(Greeting greeting) {
		producerTemplate.requestBody("direct:sendMessage", greeting);
		System.out.println("MSG SENT______________");
		//producerTemplate.sendBody("direct:sendMessage", greeting);
		//jsmTemplate.convertAndSend(SIMPLE_QUEUE, greeting);
    }
	
	public void printQueue(Greeting greeting)
	{
		System.out.println(SIMPLE_QUEUE+"-------"+greeting.getMsg());
		System.out.println(SIMPLE_QUEUE+"-------"+greeting.getCount());
		//Optional optional=Optional.ofNullable(greeting.getCount());
		//System.out.println(optional.toString());
		
		//producerTemplate.requestBody("direct:msgExchange", greeting);
	}
	public String returnQueue()
	{
		return SIMPLE_QUEUE;
	}
	@Transactional
	public void msgExchange(Exchange exchange)
	{
		Greeting greeting=(Greeting)exchange.getIn().getBody();
		greeting.setCount(5);
		exchange.setProperty("count", greeting.getCount());
		producerTemplate.sendBody("direct:msgExchange",greeting);
		System.out.println("from exchange  "+greeting.getMsg()+"   :"+greeting.getCount());
	}
	@Transactional
	public void postToTopic(Exchange exchange) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;

		try {
			Greeting greeting=(Greeting)exchange.getIn().getBody();
			json = mapper.writeValueAsString(greeting);//
			JSONObject jsonObject = new JSONObject(json);
			//jsonObject.put("order", "/" + exchange.getProperty("orderID"));
			System.out.println("json data---"+json);
			log.info("Msg Sending----");
			producerTemplate.sendBody("direct:jsonExchange",jsonObject.toString());
		} catch (Exception e) {
			log.debug("Problem occurred in adding Order Associated Party");
		}
	}

}
