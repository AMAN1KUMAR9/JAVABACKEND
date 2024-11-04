package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LyfMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/Lyfconfig.xml");
		Lifecycle lyf  =(Lifecycle)context.getBean("lifcycle");
		
		System.out.println(lyf);
	

		
		Laif lyff  =(Laif)context.getBean("laif");
		
		System.out.println(lyff);
		
		AnnotLifecycle lyf1  =(AnnotLifecycle)context.getBean("Annot");
		
		System.out.println(lyf1);
		context.registerShutdownHook();
	}

}
