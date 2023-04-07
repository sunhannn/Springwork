package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice {

	public void beforeLog(JoinPoint jp) {
		// JoinPoint : ����Ʈ�� �޼ҵ��� ������ ��� Ŭ����
		// getSignature() : ����Ʈ�� �޼ҵ��� �޼ҵ��, �Ű��������� ������ ������.
		// getName() : getSignature() �޼ҵ尡 ���� ���� �� �޼ҵ� ���� ������.
		// getArgs() : getSignature() �޼ҵ尡 ���� ���� �� �Ű� ���� ������ ������.
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();

		System.out.println("[����ó��]" + method + "() �޼ҵ� args ���� :" + args[0].toString());

	}

}