package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
//@After("execution(* com.springbook.biz..*Impl.*(..))")
	public void finallyLog() {
		System.out.println("[����ó��] ����Ͻ� ���� ���� �� ������ ����");
	}

}