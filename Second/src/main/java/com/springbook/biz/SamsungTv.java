package com.springbook.biz;

public class SamsungTv implements Tv {
	private Speaker speaker;
	private int price;

	public SamsungTv() {
		System.out.println("===> SamsungTv()");

	}

	public SamsungTv(Speaker speaker) {
		System.out.println("===> SamsungTv(Speaker) ��ü ����");
		this.speaker = speaker;

	}

	public SamsungTv(Speaker speaker, int price) {
		System.out.println("===> SamsungTv(Speaker, price) ��ü ����");
		this.speaker = speaker;
		this.price = price;

	}

	@Override
	public void powerOff() {
		System.out.println("samsungTv ----������ ����.");
	}

	@Override
	public void powerOn() {
		System.out.println("samsungTv ----������ �Ҵ�. (����" + price + ")");

	}

	@Override
	public void volumnDown() {
		speaker.volumnDown();
		System.out.println("�Ҹ��� �ø���.");

	}

	@Override
	public void volumnUp() {
		speaker.volumnUp();
		
		System.out.println("�Ҹ��� ������. ");
	}

}