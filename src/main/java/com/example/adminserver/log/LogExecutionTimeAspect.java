package com.example.adminserver.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Aspect
@Component
@EnableAspectJAutoProxy // 启用AOP
public class LogExecutionTimeAspect {

//    @Around("@annotation(com.example.adminserver.log.LogExecutionTime)")
//    public void logExecutionTime(ProceedingJoinPoint joinPoint) {
//        System.out.println("around");
//    }

    @Pointcut("@annotation(com.example.adminserver.log.LogExecutionTime)")
    public void logTime(){}

    @Before("logTime()")
    public void before(JoinPoint joinPoint){
        System.out.println("before");
    }

//    @After("logTime()")
//    public void after(JoinPoint joinPoint){
//        System.out.println("after");
//    }

    @AfterReturning("logTime()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("afterReturning");
    }

    @AfterThrowing("logTime()")
    public void afterThrowing(JoinPoint joinPoint){
        System.out.println("afterThrowing");
    }
}
