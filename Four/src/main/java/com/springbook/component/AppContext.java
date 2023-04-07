package com.springbook.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 없어도 됨 
@ComponentScan(basePackages = { "com.springbook.component" })// 객체 만들거 찾기
public class AppContext {

	@Bean
	public LgTv tv() {
		return new LgTv();

	}
	@Bean
	public SamsungTv stv() {
		return new SamsungTv();
	}
	
	@Bean
	public int price() {
		return 300000;
	}
	
}
