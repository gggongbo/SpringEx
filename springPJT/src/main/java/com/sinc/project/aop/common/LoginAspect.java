package com.sinc.project.aop.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("loginAspect")
@Aspect
///POJO형식 누구도 상속 받지 않음
public class LoginAspect {

	@Before("execution(public * com.sinc.project.aop.core..*Impl.say*(..))")
	public void before(JoinPoint join) {
		System.out.println("aspect >>>>>>>>>>>>>>>> before advice");
	}

	/////매개변수의 이름을 맞춰줘야 함.
	@AfterThrowing(pointcut = "execution(public * com.sinc.project.aop.core..*Impl.say*(..))",
				   throwing = "e")
	public void throwing(JoinPoint point, Exception e) {
		System.out.println("throwing>>>>>>>>>>");
		e.printStackTrace();
	}
}
