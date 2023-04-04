package com.springbook.biz;

public class Samsung implements Tv {
	public void initSamsung() {
		System.out.println("삼성 tv 초기 메소드 실행");

	}

	@Override
	public void powerOff() {
		System.out.println("s전원 끄기");

	}

	@Override
	public void powerOn() {
		System.out.println("s전원 켜기");

	}

	@Override
	public void volumnDown() {
		System.out.println("s볼륨 내리기");
	}

	@Override
	public void volumnUp() {
		System.out.println("s볼륨 올리기");

	}

	public void destroySamsung() {
		System.out.println("삼성TV 객체 삭제 전 호출 메소드");
	}
}
