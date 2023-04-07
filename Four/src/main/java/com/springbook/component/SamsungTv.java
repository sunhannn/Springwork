package com.springbook.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component("stv")
public class SamsungTv implements Tv {
	@Autowired @Qualifier("apple")
	private Speaker speaker;
	@Autowired
	private int price;

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