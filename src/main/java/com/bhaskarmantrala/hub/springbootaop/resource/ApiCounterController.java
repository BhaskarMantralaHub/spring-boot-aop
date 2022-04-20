package com.bhaskarmantrala.hub.springbootaop.resource;

import com.bhaskarmantrala.hub.springbootaop.helper.ApiHitCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author venkata.mantrala
 */
@RestController
@RequestMapping("/aop")
public class ApiCounterController {

    @Autowired
    ApiHitCounter apiHitCounter;

    @GetMapping("/counter")
    public ResponseEntity<Integer> counterValue() {
        return new ResponseEntity<>(apiHitCounter.getCount(), HttpStatus.ACCEPTED);
    }

}
