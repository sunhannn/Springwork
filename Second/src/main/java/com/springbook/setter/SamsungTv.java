package com.springbook.setter;

public class SamsungTv implements Tv {
	private Speaker speaker;
	private int price;

	public void setSpeaker(Speaker speaker) {
		System.out.println("=====> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("=====> setPrice() 호출");
		this.price = price;
	}

	@Override
	public void powerOff() {
		System.out.println("samsungTv ----전원을 끈다.");
	}

	@Override
	public void powerOn() {
		System.out.println("samsungTv ----전원을 켠다. (가격" + price + ")");

	}

	@Override
	public void volumnDown() {
		speaker.volumnDown();
		System.out.println("소리를 올린다.");

	}

	@Override
	public void volumnUp() {
		speaker.volumnUp();

		System.out.println("소리를 내린다. ");
	}

}
