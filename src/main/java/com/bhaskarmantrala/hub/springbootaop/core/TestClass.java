package com.bhaskarmantrala.hub.springbootaop.core;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @author venkata.mantrala
 */
@Component
@Log4j2
public class TestClass {

    public void invokeMethod() {
        log.info("invokeMethod is called");
    }

}
