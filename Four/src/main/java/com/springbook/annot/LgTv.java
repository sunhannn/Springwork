package com.springbook.annot;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;


@Component("tv")
public class LgTv implements Tv {
//	@Autowired @Qualifier("sony")
//	@Resource(name="apple")
	@Inject @Named("sony")
	private Speaker speaker;

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
		speaker.volumnDown();
		System.out.println("lg볼륨 내리기");
	}

	@Override
	public void volumnUp() {
		speaker.volumnUp();
		System.out.println("lg볼륨 올리기");
	}

}
