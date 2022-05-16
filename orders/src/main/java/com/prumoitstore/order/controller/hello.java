package com.prumoitstore.order.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class hello {

    @GetMapping("/hello")
    public String helloWord(){
        return "onlineNow";
    }
}
