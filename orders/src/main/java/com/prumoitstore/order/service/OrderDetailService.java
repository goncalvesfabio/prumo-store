package com.prumoitstore.order.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.prumoitstore.order.domain.Client;
import com.prumoitstore.order.domain.OrderDetail;
import com.prumoitstore.order.repository.ClientRepository;
import com.prumoitstore.order.repository.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final ClientRepository clientRepository;


    public List<OrderDetail> findAll(){
        return orderDetailRepository.findAll();
    }

    public OrderDetail addNewOrder(OrderDetail orderDetail) {
        Optional<Client> clientOptional = clientRepository.findById(orderDetail.getClient().getId());
        Client client = clientOptional.get();
        orderDetail.setClient(client);
        return orderDetailRepository.save(orderDetail);
    }
}
