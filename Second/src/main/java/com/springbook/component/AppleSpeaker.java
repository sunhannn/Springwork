package com.springbook.component;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {

	public AppleSpeaker() {
		System.out.println("====> AppleSpeaker ��ü ����");

	}

	@Override
	public void volumnDown() {
		System.out.println("====> AppleSpeaker �Ҹ��� ������");
	}

	@Override
	public void volumnUp() {
		System.out.println("====> AppleSpeaker �Ҹ��� �ø���");
	}

}