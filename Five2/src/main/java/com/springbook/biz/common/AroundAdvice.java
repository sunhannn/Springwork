package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
//	@Around("execution(* com.springbook.biz..*Impl.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();

		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		System.out.println("[AroundAdvice]" + method + "() 메소드 실행 전");

		// 실제 포인트컷 메소드가 실행되는 시점
		Object returnObj = pjp.proceed();

		stopwatch.stop();
		System.out.println(
				"[AroundAdvice]:" + method + "()메소드 실행 후 수행에 걸린 시간 : " + stopwatch.getTotalTimeMillis() + "(ms)초");
		return returnObj;
	}

}
