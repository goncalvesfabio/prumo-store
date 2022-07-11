package com.prumoitstore.order.controller;
import com.prumoitstore.order.domain.OrderDetail;
import com.prumoitstore.order.service.OrderDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@AllArgsConstructor
@Log4j2
public class OrderDetailController {

    private final OrderDetailService orderDetailService;
    // private final DateUtil dateUtil;
    /*
    @GetMapping("/orders")
    public String orderList(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return "orderController";

    }
    */
    @PostMapping("/orders")
    public ResponseEntity<OrderDetail> creatingOrder(@RequestBody OrderDetail orderDetail){
        orderDetailService.addNewOrder(orderDetail);
        return new ResponseEntity<>(orderDetail, HttpStatus.CREATED);
    }

}
