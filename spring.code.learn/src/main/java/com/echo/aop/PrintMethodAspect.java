package com.echo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintMethodAspect {

    @Before("@annotation(com.echo.anotation.PrintMethodAnotationTest)")
    public void enhanceMethod(JoinPoint joinPoint){
//        System.out.println();
        System.out.println("methodName:"+joinPoint.getSignature().getName());
    }
}
