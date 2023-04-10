package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void beforeLog(JoinPoint jp) {

//		@Before("allPointcut()")
//		@Before("execution(* com.springbook.biz..*Impl.*(..))")
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();

		System.out.println("[����ó��]" + method + "() �޼ҵ� args ���� :" + args[0].toString());

	}

//	@Before("PointcutCommon.allPointcut()")
//	public void beforeLog(JoinPoint jp) {
//
//		String method = jp.getSignature().getName();
//		Object[] args = jp.getArgs();
//
//		System.out.println("[����ó��]" + method + "() �޼ҵ� args ���� :" + args[0].toString());
//
//	}
}