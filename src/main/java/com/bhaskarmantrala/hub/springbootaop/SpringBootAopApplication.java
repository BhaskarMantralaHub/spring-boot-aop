package com.bhaskarmantrala.hub.springbootaop;

import com.bhaskarmantrala.hub.springbootaop.advice.CustomAdvice;
import com.bhaskarmantrala.hub.springbootaop.config.Config;
import com.bhaskarmantrala.hub.springbootaop.core.TestClass;
import com.bhaskarmantrala.hub.springbootaop.core.TestClassWithAnnotation;
import com.bhaskarmantrala.hub.springbootaop.helper.ApiHitCounter;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@Log4j2
public class SpringBootAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        TestClass testClass = context.getBean(TestClass.class);
        testClass.invokeMethod();
        String response = testClass.invokeMethodWithParams("Bhaskar");

        TestClassWithAnnotation testClassWithAnnotation = context.getBean(TestClassWithAnnotation.class);
        testClassWithAnnotation.invokeMethodByNumberOfTimes(10, 1);


        testClassWithAnnotation.nullCheckMethod(null);
    }

}
