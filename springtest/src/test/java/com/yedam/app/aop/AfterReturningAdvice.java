package com.yedam.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningAdvice {
	
	@Pointcut("execution(* com.yedam.app..*Impl.select*(..))")
	public void selectPointcut() {
		
	}
	@AfterReturning(pointcut = "LogAdvice.allpointcut()", returning="returnObj")
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
