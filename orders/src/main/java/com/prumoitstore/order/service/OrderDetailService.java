package com.prumoitstore.order.service;

import com.prumoitstore.order.domain.Client;
import com.prumoitstore.order.domain.OrderDetail;
import com.prumoitstore.order.repository.ClientRepository;
import com.prumoitstore.order.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;


    public List<OrderDetail> findAll(){
        return orderDetailRepository.findAll();
    }

    public OrderDetail addNewOrder(OrderDetail orderDetail) {
            return orderDetailRepository.save(orderDetail);
    }
}
