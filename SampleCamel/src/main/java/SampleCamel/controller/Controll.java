package SampleCamel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SampleCamel.dto.Greeting;
import SampleCamel.service.GreetingListner;
import SampleCamel.service.GreetingService;

@RestController
public class Controll {

	
	@Autowired
	private GreetingService greetingService;
	@Autowired
	private GreetingService greetinService;
	@Autowired
	private GreetingListner greetingListner;
	
	@RequestMapping("/")
	public String hello()
	{
		return "Hello";
	}
	@RequestMapping("/send")
	public void m1()
	{
		Greeting greeting=new Greeting("HAA");
		System.out.println("MSG SENT______________");
		System.out.println("----"+greeting.getMsg()+"----");
		greetingService.addGreeting(greeting);
		
	}
	@RequestMapping("/recive")
	public void m2()
	{
		//greetingListner.receiveQueue();
	}
}
