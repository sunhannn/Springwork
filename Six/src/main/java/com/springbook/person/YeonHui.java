package com.springbook.person;

import org.springframework.stereotype.Component;

@Component("yeonHui")
public class YeonHui implements People{
	
	
	@Override
	public void getHome() {
		System.out.println("���� ���� ������ ����");
		System.out.println("�����ν��� �Ѵ�.");
		
		
		
	}
}