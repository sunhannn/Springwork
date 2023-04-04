package com.springbook.setter;

public class SamsungTv implements Tv {
	private Speaker speaker;
	private int price;

	public void setSpeaker(Speaker speaker) {
		System.out.println("=====> setSpeaker() ȣ��");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("=====> setPrice() ȣ��");
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