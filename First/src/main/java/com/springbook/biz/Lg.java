package com.springbook.biz;

public class Lg implements Tv {
	public Lg() {
		System.out.println("1LgTv ��ü ����");

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
