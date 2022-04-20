package com.bhaskarmantrala.hub.springbootaop.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author venkata.mantrala
 */
@Aspect
@Component
@Log4j2
public class AnnotationAdvice {

    @Around("@annotation(com.bhaskarmantrala.hub.springbootaop.annotations.NullCheck)")
    public Object nullCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Inside null check method");
        String methodName = joinPoint.getSignature().getName();
        Object[] joinPointArgs = joinPoint.getArgs();
        for (Object joinPointArg : joinPointArgs) {
            if (joinPointArg == null) {
                throw new IllegalArgumentException(methodName + " method arguments cannot be null");
            }
        }
        return joinPoint.proceed(joinPointArgs);
    }

}
