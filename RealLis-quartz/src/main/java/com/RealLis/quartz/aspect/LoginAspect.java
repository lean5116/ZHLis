package com.RealLis.quartz.aspect;

import com.RealLis.common.utils.ServletUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
    @Pointcut(value = "@annotation(com.RealLis.quartz.anno.Auth)")
   // @Pointcut("execution(public * com.RealLis.quartz.service.*.*(..))")
    public void LoginAspect(){

    }
    @Before("LoginAspect()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("doBefore");
    }
    @After("LoginAspect()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("doAfter");
    }

    @AfterReturning("LoginAspect()" )
    public void doAfterReturning(JoinPoint joinPoint){
        System.out.println("doAfterReturning");
    }

    @AfterThrowing("LoginAspect()")
    public void deAfterThrowing(JoinPoint joinPoint){
        System.out.println("deAfterThrowing");
    }

    @Around("LoginAspect()")
    public Object deAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("deAround");
        if(ServletUtils.getSession().getAttribute("LoginName")!=null){
            return joinPoint.proceed();
        }else {
            return null;
        }
    }
}
