package com.springbook.component;

import org.springframework.stereotype.Component;

@Component("tv")
public class LgTv implements Tv {
	public LgTv() {
		System.out.println("LgTv 객체 생성");

	}

	@Override
	public void powerOff() {
		System.out.println("lg전원 끄기");

	}

	@Override
	public void powerOn() {
		System.out.println("lg전원 켜기");
	}

	@Override
	public void volumnDown() {
		System.out.println("lg볼륨 내리기");
	}

	@Override
	public void volumnUp() {
		System.out.println("lg볼륨 올리기");
	}

}
