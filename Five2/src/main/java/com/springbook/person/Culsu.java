package com.springbook.person;

import org.springframework.stereotype.Component;

@Component("culSu")
public class Culsu implements People {
	@Override
	public void getHome() {

		System.out.println("ö���� ���� ������ ����");
		System.out.println("���踦 �����´�.");

	}

}