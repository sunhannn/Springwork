package com.springbook.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");

		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup)�Ѵ�.
		Tv tv = (Tv) factory.getBean("tv");

		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
		// 3. Spring �����̳ʸ� �����Ѵ�.
		factory.close();

	}

}