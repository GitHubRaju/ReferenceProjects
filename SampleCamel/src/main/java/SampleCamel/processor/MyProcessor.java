package SampleCamel.processor;

import java.util.Optional;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


import SampleCamel.dto.Greeting;


public class MyProcessor implements Processor{

	@Override
	public void process(Exchange arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Greeting greet=(Greeting)arg0.getIn().getBody();
		Optional<Greeting> gree=Optional.ofNullable(greet);
		if(gree.isPresent()){
		if(gree.get().equals("HAA"))
		{
			arg0.setProperty("msg","DONE");
			arg0.setProperty("count", 6);
		}
	}
	}

}
