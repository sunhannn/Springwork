package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect ¾ø¾îµµ µÊ
public class PointcutCommon {
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {
	}

	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void getPointcut() {
	}

}
