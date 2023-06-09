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
		speaker.volumnDown();
		System.out.println("lg���� ������");
	}

	@Override
	public void volumnUp() {
		speaker.volumnUp();
		System.out.println("lg���� �ø���");
	}

}
