package com.bhaskarmantrala.hub.springbootaop.helper;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @author venkata.mantrala
 */
@Component
@Data
@Log4j2
public class ApiHitCounter {

    private Integer count = 0;

}
