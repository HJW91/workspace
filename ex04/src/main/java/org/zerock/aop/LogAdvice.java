package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {
	@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("============================");
	}
	
	@AfterThrowing(pointcut="execution(* org.zerock.service.SampleService*.*(..))",throwing="exception")
	public void logException(Exception exception) {
		log.info("Exception.....!!!!!");
		log.info("exception : " + exception);
	}
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		log.info("Target : " + pjp.getTarget());
		log.info("Param :  " + Arrays.deepToString(pjp.getArgs()));
		Object result = null;
		try {
			result = pjp.proceed();
		}catch(Throwable e) {
			
		}
		long end = System.currentTimeMillis();
		log.info("TIME : " + (end-start));
		return result;
	}
	
}