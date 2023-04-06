package com.springbook.annot;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println("====> SonySpeaker ��ü ����");

	}

	@Override
	public void volumnDown() {
		System.out.println("====> SonySpeaker �Ҹ� ����������");
	}

	@Override
	public void volumnUp() {
		System.out.println("====> SonySpeaker �Ҹ� �÷�������");
	}

}