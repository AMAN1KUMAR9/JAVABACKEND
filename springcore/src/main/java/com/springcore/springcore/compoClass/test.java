package com.springcore.springcore.compoClass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext con = new AnnotationConfigApplicationContext(configNoXML.class);
		Compo com = con.getBean("com" ,Compo.class);
		
		System.out.println(com);
		System.out.println(com.getList());
		

	}



}
