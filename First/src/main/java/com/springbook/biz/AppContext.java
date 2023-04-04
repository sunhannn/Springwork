package com.springbook.biz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration // ������̼����� �ϰٴ�
public class AppContext {
	// Samsung ��ü �����ϱ� ��ü�� : stv
	// <bean id="greeter" class="com.springbook.biz.Greeter">
	@Bean
	@Scope("prototype")
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, �ȳ��ϼ���!");
		return g;

	}

	@Bean
	public Greeter greeter1() {
		Greeter g = new Greeter();
		g.setFormat("%s, �����մϴ�!");
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