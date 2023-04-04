package com.springbook.biz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
// AnnotationConfigApplicationContext 자바 설정 정보를 읽어오는 클래스
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g = ctx.getBean("greeter", Greeter.class);
		// Greeter g =(Greeter) ctx.getBean("greeter");
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		msg = g1.greet("스프링");
		System.out.println(msg);

		Greeter s1 = ctx.getBean("greeter1", Greeter.class);
		msg = s1.greet("스프링");
		System.out.println(msg);
		int i = ctx.getBean("inter", Integer.class);
		System.out.println("i의 값은" + i);

		System.out.println(g);
		System.out.println(g1);
		System.out.println(g == g1);
		System.out.println(g1 == s1);
		
		
		// 삼성 객체 얻어와서 객체를 통해 powerOn()메소드 호출하기
		Samsung s = ctx.getBean("stv",Samsung.class);
		
		s.powerOn();
		
		
		
		ctx.close();

	}

}
