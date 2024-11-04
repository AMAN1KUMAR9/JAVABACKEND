package com.springcore.springcore.compo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext con = new ClassPathXmlApplicationContext("com/springcore/springcore/compo/compoconfig.xml");
		Compo com = con.getBean("compo" ,Compo.class);
		
		System.out.println(com);
		

	}



}
