package com.bhaskarmantrala.hub.springbootaop;

import com.bhaskarmantrala.hub.springbootaop.advice.CustomAdvice;
import com.bhaskarmantrala.hub.springbootaop.config.Config;
import com.bhaskarmantrala.hub.springbootaop.core.TestClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        TestClass testClass = context.getBean(TestClass.class);
        testClass.invokeMethod();
    }

}
