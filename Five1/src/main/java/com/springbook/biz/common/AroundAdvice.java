package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {

	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();

		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		System.out.println("[AroundAdvice]" + method + "() �޼ҵ� ���� ��");

		// ���� ����Ʈ�� �޼ҵ尡 ����Ǵ� ����
		Object returnObj = pjp.proceed();

		stopwatch.stop();
		System.out.println(
				"[AroundAdvice]:" + method + "()�޼ҵ� ���� �� ���࿡ �ɸ� �ð� : " + stopwatch.getTotalTimeMillis() + "(ms)��");
		return returnObj;
	}

}