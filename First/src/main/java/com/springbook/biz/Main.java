package com.springbook.biz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
// AnnotationConfigApplicationContext �ڹ� ���� ������ �о���� Ŭ����
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g = ctx.getBean("greeter", Greeter.class);
		// Greeter g =(Greeter) ctx.getBean("greeter");
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("������");
		System.out.println(msg);
		msg = g1.greet("������");
		System.out.println(msg);

		Greeter s1 = ctx.getBean("greeter1", Greeter.class);
		msg = s1.greet("������");
		System.out.println(msg);
		int i = ctx.getBean("inter", Integer.class);
		System.out.println("i�� ����" + i);

		System.out.println(g);
		System.out.println(g1);
		System.out.println(g == g1);
		System.out.println(g1 == s1);
		
		
		// �Ｚ ��ü ���ͼ� ��ü�� ���� powerOn()�޼ҵ� ȣ���ϱ�
		Samsung s = ctx.getBean("stv",Samsung.class);
		
		s.powerOn();
		
		
		
		ctx.close();

	}

}