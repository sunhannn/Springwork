package com.springbook.component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext(AppContext.class);

		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
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

		// 3. Spring 컨테이너를 종료한다.
		factory.close();

	}

}
