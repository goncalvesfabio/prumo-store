package com.prumoitstore.order.controller;
import com.prumoitstore.order.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
@RestController
@AllArgsConstructor
@Log4j2
public class orderController {
    private final DateUtil dateUtil;

    @GetMapping("/newOrder")
    public String orderList(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return "orderController";

    }
}
