package com.springbook.person;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonClient {
	public static void main(String[] args) {

		AbstractApplicationContext container = new GenericXmlApplicationContext("personContext.xml");

		People p = (People) container.getBean("culSu");
		p.getHome();
		
		System.out.println("=================================");
		p = (People) container.getBean("yeonHui");
		p.getHome();

		container.close();
	}

}
