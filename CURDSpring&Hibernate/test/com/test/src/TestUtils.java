package com.test.src;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUtils 
{

	private static ApplicationContext ctx;
	static
	{
		ctx=new ClassPathXmlApplicationContext("test.xml");
	}

public static Object getObject(String name)
{
	return ctx.getBean(name);
}
}
