package com.prumoitstore.order.service;

import com.prumoitstore.order.domain.Address;
import com.prumoitstore.order.domain.Client;
import com.prumoitstore.order.repository.AddressRepository;
import com.prumoitstore.order.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.util.BeanDefinitionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findById(Integer id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client not Found"));
    }

/*
    @Transactional
    public Client addClient(Client client){
        return clientRepository.save(client);
    }
 */
    public Client addClient(Client client){
        return clientRepository.save(client);
    }


    @Transactional
    public String deleteClient(Integer id){
        clientRepository.deleteById(id);
        return "client removed!!" + id;
    }
    @Transactional
    public Client updateClient( Integer id,Client client){
        Client existingClient = clientRepository.findById(id).get();
        BeanUtils.copyProperties(client, existingClient,"id");
        return clientRepository.save(existingClient);
    }


}
