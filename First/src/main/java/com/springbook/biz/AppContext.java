package com.springbook.biz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration // 어노테이션으로 하겟다
public class AppContext {
	// Samsung 객체 생성하기 객체명 : stv
	// <bean id="greeter" class="com.springbook.biz.Greeter">
	@Bean
	@Scope("prototype")
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요!");
		return g;

	}

	@Bean
	public Greeter greeter1() {
		Greeter g = new Greeter();
		g.setFormat("%s, 시작합니다!");
		return g;

	}

	// <bean id="inter" class="java.lang.Integer">
	@Bean
	public int inter() {
		return 50;
	}

	@Bean(initMethod = "initSamsung")
	public Samsung stv() {
		Samsung s = new Samsung();
		return s;

	}
}
