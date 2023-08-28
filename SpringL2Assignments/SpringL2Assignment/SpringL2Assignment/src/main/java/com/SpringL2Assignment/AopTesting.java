package com.SpringL2Assignment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AopTesting {

	long before;

	@Before("execution(* com.SpringL2Assignment.StudentDao.get*(..))")
	public void beforeExcecution(JoinPoint jp) {
		before=System.currentTimeMillis();
		
	}
	@After("execution(* com.SpringL2Assignment.StudentDao.get*(..))")
	public void AfterExecution(JoinPoint jp) {
		long after=System.currentTimeMillis();
		Log log =LogFactory.getLog(AopTesting.class);
		long restime=after-before;
		log.info("Method Name : "+jp.getSignature().getName()+" Before Executing time of method : "+before+" After excecuting time : "+after+" Time Taken to execute : "+restime );
	}
}
