package com.springbook.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TvMain {

	public static void main(String[] args) {
		// GenericXmlApplicationcontext ���Ͻý����̳� Ŭ���� ��ο� �ִ� xml���� ������ �ε��Ͽ�
		// �����ϴ� �����̳� Ŭ���� (�����������̳� ����)
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		Tv tv = (Tv) factory.getBean("stv");
		tv = (Tv) factory.getBean("stv");
		tv = (Tv) factory.getBean("stv");
		// �̱����̶� ��ü �ּ� �� ������
		tv.powerOn();
		tv.volumnDown();
		tv.volumnDown();
		tv.powerOff();

		System.out.println("============================\n");
		tv = (Tv) factory.getBean("ltv");
		tv = (Tv) factory.getBean("ltv");
		tv = (Tv) factory.getBean("ltv");
		// name���� ��ü�� ���������� "http://lg"
		tv.powerOn();
		tv.volumnDown();
		tv.volumnDown();
		tv.powerOff();
		factory.close();
	}

}