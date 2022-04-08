package com.bhaskarmantrala.hub.springbootaop.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author venkata.mantrala
 */
@Component
@Aspect
@Log4j2
public class CustomAdvice {

    @Pointcut("execution(public void com.bhaskarmantrala.hub.springbootaop.core.TestClass.invokeMethod())")
    public void pointCut() {}

    @Before("pointCut()")
    public void beforeAdvice() {
        log.info("Inside Before Advice method");
    }
}
