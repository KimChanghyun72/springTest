package com.yedam.app.aop;

import org.aspectj.lang.JoinPoint;


public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object returnObj){
		String method = jp.getSignature().getName();
		String result = returnObj != null ? returnObj.toString() : "";
		/*if( returnObj instanceof BoardVO ) {
			System.out.println(returnObj);
			result = ((BoardBeans)returnObj).getSubject();
		}*/
		System.out.println("[사후처리] 로직 수행 후 동작" +
		                    method + " : " + 
		                    result );
	}
}
