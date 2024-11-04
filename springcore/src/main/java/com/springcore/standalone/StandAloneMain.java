package com.springcore.standalone;

import java.net.Socket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StandAloneMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/standalone/StandAloneconfig.xml");
		StandAlone  sa = (StandAlone)context.getBean("util");
		System.out.println(sa.getList().getClass().getName());
		
	}

}
