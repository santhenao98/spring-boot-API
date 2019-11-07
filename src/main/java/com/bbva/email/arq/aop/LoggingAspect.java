package com.bbva.email.arq.aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Date :September 25,2019
 * 
 * @author SantiagoTH
 * @version 1.0
 *
 */

@Aspect
@Component
public class LoggingAspect {

	public static Logger logger = Logger.getLogger("aspect");
	/*
	 * 
	 * Aspect for app Before After Around
	 * 
	 */

	@Before("execution( public * com.bbva.email.controller.*.*(..)) || execution( public * com.bbva.email.service.*.*(..)) || execution( public * com.bbva.email.daoImpl.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {

		logger.info("Before " + joinPoint.getThis() + "|" + joinPoint.getSignature().getName() + "|"
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@After("execution( public * com.bbva.email.controller.*.*(..)) || execution( public * com.bbva.email.service.*.*(..)) || execution( public * com.bbva.email.daoImpl.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {

		logger.info("After " + joinPoint.getThis() + "|" + joinPoint.getSignature().getName() + "|"
				+ Arrays.toString(joinPoint.getArgs()));
	}

	@Around("execution( public * com.bbva.email.controller.*.*(..)) || execution( public * com.bbva.email.service.*.*(..)) || execution( public * com.bbva.email.daoImpl.*.*(..))")
	public Object catchException(ProceedingJoinPoint joinpoint) throws Throwable {
		Object exit = null;
		try {
			exit = joinpoint.proceed();
		} catch (Exception e) {
			logger.error("***************************GENERANDO REPORTE ********************************");
			logger.info("Reporte de Error capturado ");
			logger.info("Clase : " + joinpoint.getTarget().getClass());
			logger.info("Metodo : " + joinpoint.getSignature().getName());
			logger.info("Variables : " + Arrays.toString(joinpoint.getArgs())+"\n");
			logger.info("Exception : "+e +"\n");  
			logger.info("Message :"+e.getMessage());
			logger.info("Cause : "+ e.getCause());  
		}
		return exit;
	}

}
