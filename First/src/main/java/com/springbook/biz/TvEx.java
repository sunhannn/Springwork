package com.springbook.biz;

public class TvEx {

	public static void main(String[] args) {

		Tv tv = new Lg();
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
		System.out.println("���� Ƽ�� ����");
		
		tv = new Samsung();
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
		
		
		
		

	}

}
