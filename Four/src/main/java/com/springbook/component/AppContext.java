package com.springbook.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // ��� �� 
@ComponentScan(basePackages = { "com.springbook.component" })// ��ü ����� ã��
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
