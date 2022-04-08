package com.bhaskarmantrala.hub.springbootaop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author venkata.mantrala
 */
@Configuration
@ComponentScan(basePackages = {"com.bhaskarmantrala.hub.springbootaop.core",
        "com.bhaskarmantrala.hub.springbootaop.advice"})
@EnableAspectJAutoProxy
public class Config {
}
