package com.springcore.springcore.ref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MNNN {
	@Autowired
    private Reef reef1;

    public Reef getR1() {
        return reef1;
    }

    public void setR1(Reef r1) {
        this.reef1 = r1;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/springcore/ref/RefConfig.xml");
        MNNN mnnn = context.getBean("mnnn", MNNN.class);

        System.out.println(mnnn.getR1());
    }
}
