package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

	public void beforeLog(JoinPoint jp) {
		// JoinPoint : 포인트컷 메소드의 정보를 담는 클래스
		// getSignature() : 포인트컷 메소드의 메소드명, 매개변수등의 정보를 가져옴.
		// getName() : getSignature() 메소드가 가진 정보 중 메소드 명만 가져옴.
		// getArgs() : getSignature() 메소드가 가진 정보 중 매개 변수 정보만 가져옴.
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();

		System.out.println("[사전처리]" + method + "() 메소드 args 정보 :" + args[0].toString());

	}

}
