package com.springbook.component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(AppContext.class);

		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û(Lookup)�Ѵ�.
//		Tv tv = (Tv) factory.getBean("lgTv");
		Tv tv = (Tv) factory.getBean("tv");

		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();

		tv = (Tv) factory.getBean("stv");
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();

		// 3. Spring �����̳ʸ� �����Ѵ�.
		factory.close();

	}

}