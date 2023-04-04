package com.springbook.biz;

public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println("====> SonySpeaker 按眉 积己");

	}

	@Override
	public void volumnDown() {
		System.out.println("====> SonySpeaker 家府 郴妨滚府扁");
	}

	@Override
	public void volumnUp() {
		System.out.println("====> SonySpeaker 家府 棵妨滚府扁");
	}

}
