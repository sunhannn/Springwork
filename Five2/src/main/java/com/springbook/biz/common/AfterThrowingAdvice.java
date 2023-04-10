package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
//@AfterThrowing(pointcut = "execution(* com.springbook.biz..*Impl.*(..))",throwing = "exceptObj")
	public void afterThrowingLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		System.out.println("[����ó��]" + method + "()�޼ҵ� ���� �� �߻��� ���� �޼��� : " + exceptObj.getMessage());

		if (exceptObj instanceof IllegalArgumentException) {
			System.out.println("�������� ���� �ԷµǾ����ϴ�.");
		} else if (exceptObj instanceof NumberFormatException) {
			System.out.println("���� ������ ���� �ƴմϴ�.");
		} else if (exceptObj instanceof Exception) {
			System.out.println("������ �߻��߽��ϴ�.");
		}

	}

}