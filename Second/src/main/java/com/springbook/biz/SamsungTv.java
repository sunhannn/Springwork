package com.springbook.biz;

public class SamsungTv implements Tv {
	private Speaker speaker;
	private int price;

	public SamsungTv() {
		System.out.println("===> SamsungTv()");

	}

	public SamsungTv(Speaker speaker) {
		System.out.println("===> SamsungTv(Speaker) 객체 생성");
		this.speaker = speaker;

	}

	public SamsungTv(Speaker speaker, int price) {
		System.out.println("===> SamsungTv(Speaker, price) 객체 생성");
		this.speaker = speaker;
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
