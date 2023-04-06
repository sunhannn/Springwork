package com.springbook.annot;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("annotContext.xml");

		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
//		Tv tv = (Tv) factory.getBean("lgTv");
		Tv tv = (Tv) factory.getBean("tv");

		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();

		// 3. Spring 컨테이너를 종료한다.
		factory.close();

	}

}
