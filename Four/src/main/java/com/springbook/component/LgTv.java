package com.springbook.component;

import org.springframework.stereotype.Component;

@Component("tv")
public class LgTv implements Tv {
	public LgTv() {
		System.out.println("LgTv ��ü ����");

	}

	@Override
	public void powerOff() {
		System.out.println("lg���� ����");

	}

	@Override
	public void powerOn() {
		System.out.println("lg���� �ѱ�");
	}

	@Override
	public void volumnDown() {
		System.out.println("lg���� ������");
	}

	@Override
	public void volumnUp() {
		System.out.println("lg���� �ø���");
	}

}
