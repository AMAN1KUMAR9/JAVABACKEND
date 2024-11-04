package com.springcore.springcore.constructorInjection;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainnnnn {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/springcore/constructorInjection/CIconfig.xml");
		Constructor cons = (Constructor)context.getBean("constr");
		System.out.println(cons);
		System.out.println(cons.addition());

}
}
