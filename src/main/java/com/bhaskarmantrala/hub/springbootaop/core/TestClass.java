package com.bhaskarmantrala.hub.springbootaop.core;

import com.bhaskarmantrala.hub.springbootaop.helper.ApiHitCounter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author venkata.mantrala
 */
@Component
@Log4j2
public class TestClass {

    public void invokeMethod() {
    }

    public String invokeMethodWithParams(String name) {
        return name;
    }

}
