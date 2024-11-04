package com.springcore.springcore.collect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class maain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context= new ClassPathXmlApplicationContext("com/springcore/springcore/collect/collectionConfig.xml");
		hello h1 = (hello)context.getBean("hello1");
		System.out.println(h1);

	}
}
