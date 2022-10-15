package org.springframework;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TheAspect {


    @Pointcut("@annotation(org.springframework.ShouldProxy)")
    public void pointCut() {}

    @Around(value = "pointCut()")
    public Object wear(ProceedingJoinPoint pjp) {
        Object returnValue = null;
        try {
            System.out.println("前置通知...");
            returnValue = pjp.proceed(pjp.getArgs());
            System.out.println("后置通知...");
        } catch (Throwable e) {
            System.out.println("异常通知...");
            throw new RuntimeException(e);
        }
        return returnValue;
    }
}
