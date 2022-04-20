package com.bhaskarmantrala.hub.springbootaop.advice;

import com.bhaskarmantrala.hub.springbootaop.annotations.CallMethod;
import com.bhaskarmantrala.hub.springbootaop.annotations.RetryWhenErrored;
import com.bhaskarmantrala.hub.springbootaop.helper.ApiHitCounter;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author venkata.mantrala
 */
@Component
@Aspect
@Log4j2
public class CustomAdvice {

    @Autowired
    ApiHitCounter apiHitCounter;

    @Pointcut("execution(* com.bhaskarmantrala.hub.springbootaop.resource.ApiCounterController.counterValue())")
    public void pointCut() {
    }

    @Pointcut("within(com.bhaskarmantrala.hub.springbootaop.core..*)")
    public void withinPackage() {
    }

    @Before("pointCut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        apiHitCounter.setCount(apiHitCounter.getCount() + 1);
    }

    @Before("execution(* com.bhaskarmantrala.hub.springbootaop.core.TestClass.*(..))")
    public void forAllCoreMethods(JoinPoint joinPoint) {
        log.info("Invoked " + joinPoint.getSignature().getName() + " method");
        log.info("Target method args are " + Arrays.toString(joinPoint.getArgs()));
    }

    @Around("withinPackage()")
    public Object forAllCoreMethodsAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Invoked " + joinPoint.getSignature().getName() + " method");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method signatureMethod = signature.getMethod();
        int executions = 1;
        int retry = 0;
        if (signatureMethod.getAnnotations().length > 0) {
            CallMethod callMethodAnnotation = signatureMethod.getAnnotation(CallMethod.class);
            RetryWhenErrored retryWhenErrored = signatureMethod.getAnnotation(RetryWhenErrored.class);
            if (callMethodAnnotation != null) executions = callMethodAnnotation.count();
            if (retryWhenErrored != null) retry = retryWhenErrored.retryCount();

            log.info("Retry count when exception occurred is " + retry);
        }
        Object result = null;
        try {
            result = joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable e) {
            log.info("Inside catch block");
            for (int i = 1; i <= retry; i++) {
                log.info("Retrying the request for " + i + "-th time");
                try {
                    result = joinPoint.proceed(joinPoint.getArgs());
                    break;
                } catch (Throwable ex) {
                    if (i >= retry) {
                        throw ex;
                    }
                }
            }
        }
        return result;
    }


}
