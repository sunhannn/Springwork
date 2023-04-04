package com.springbook.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvMain {

	public static void main(String[] args) {
		// GenericXmlApplicationcontext 파일시스템이나 클래스 경로에 있는 xml설정 파일을 로딩하여
		// 구동하는 컨테이너 클래스 (스프링컨테이너 구동)
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		Tv tv = (Tv) factory.getBean("stv");
		tv = (Tv) factory.getBean("stv");
		tv = (Tv) factory.getBean("stv");
		// 싱글톤이라서 객체 주소 다 동일함
		tv.powerOn();
		tv.volumnDown();
		tv.volumnDown();
		tv.powerOff();

		System.out.println("============================\n");
		tv = (Tv) factory.getBean("ltv");
		tv = (Tv) factory.getBean("ltv");
		tv = (Tv) factory.getBean("ltv");
		// name으로 객체명 설정했으면 "http://lg"
		tv.powerOn();
		tv.volumnDown();
		tv.volumnDown();
		tv.powerOff();
		factory.close();
	}

}
