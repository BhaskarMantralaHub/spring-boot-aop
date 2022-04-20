package com.bhaskarmantrala.hub.springbootaop.core;

import com.bhaskarmantrala.hub.springbootaop.annotations.CallMethod;
import com.bhaskarmantrala.hub.springbootaop.annotations.NullCheck;
import com.bhaskarmantrala.hub.springbootaop.annotations.RetryWhenErrored;
import org.springframework.stereotype.Component;

/**
 * @author venkata.mantrala
 */
@Component
public class TestClassWithAnnotation {

    @CallMethod(count = 1)
    @RetryWhenErrored(retryCount = 3)
    public void invokeMethodByNumberOfTimes(int value, int divideBy) {
        System.out.println("******************* Inside invokeMethodByNumberOfTimes() *******************");

        if (divideBy == 0) throw new IllegalArgumentException("Cannot be divided by zero");

        System.out.println("Divide by zero value is " + value / divideBy);

    }

    @NullCheck
    public void nullCheckMethod(String name) {
        System.out.println("******************* Inside nullCheckMethod() with arg" + name + " *******************");
    }
}
