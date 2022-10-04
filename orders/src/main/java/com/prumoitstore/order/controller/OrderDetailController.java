package com.prumoitstore.order.controller;
import com.prumoitstore.order.domain.Client;
import com.prumoitstore.order.domain.OrderDetail;
import com.prumoitstore.order.service.OrderDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@AllArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;
    /*
    @PostMapping("/orders")
   public ResponseEntity<String>testOrder(@RequestBody String orderDetail){
        String orders = orderDetail;
        return  new ResponseEntity<>(orders, HttpStatus.OK);
    }
*/
    @PostMapping("/orders")
    public ResponseEntity<OrderDetail> creatingOrder(@RequestBody OrderDetail orderDetail){
        orderDetailService.addNewOrder(orderDetail);
        return new ResponseEntity<>(orderDetail, HttpStatus.CREATED);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<OrderDetail>> findAllOrders(){
        List<OrderDetail> orders = orderDetailService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
