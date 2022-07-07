package com.prumoitstore.order.service;

import com.prumoitstore.order.domain.Client;
import com.prumoitstore.order.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client findById(Integer id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not Found"));
    }

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
