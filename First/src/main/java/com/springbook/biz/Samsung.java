package com.springbook.biz;

public class Samsung implements Tv {
	public void initSamsung() {
		System.out.println("�Ｚ tv �ʱ� �޼ҵ� ����");

	}

	@Override
	public void powerOff() {
		System.out.println("s���� ����");

	}

	@Override
	public void powerOn() {
		System.out.println("s���� �ѱ�");

	}

	@Override
	public void volumnDown() {
		System.out.println("s���� ������");
	}

	@Override
	public void volumnUp() {
		System.out.println("s���� �ø���");

	}

	public void destroySamsung() {
		System.out.println("�ＺTV ��ü ���� �� ȣ�� �޼ҵ�");
	}
}