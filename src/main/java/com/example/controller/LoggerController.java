package com.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daile on 2017/7/5.
 */
@Slf4j
@RestController
public class LoggerController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testLogLevel() {
        log.debug("Logger Level ：DEBUG");
        log.info("Logger Level ：INFO");
        log.error("Logger Level ：ERROR");
        return "";
    }

}
