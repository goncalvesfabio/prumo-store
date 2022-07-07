package com.prumoitstore.order.controller;

import com.prumoitstore.order.domain.Client;
import com.prumoitstore.order.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@SpringBootApplication
@RestController
@AllArgsConstructor
public class ClientController {

   private ClientService clientService;

    @PostMapping("/addClient")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        clientService.addClient(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @GetMapping("/listClients")
    public ResponseEntity<List<Client>> findAllClients(){
        List<Client> clients = clientService.findAll();
       return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
    }

    @GetMapping("/listClient/{id}")
    public Client findClientById(@PathVariable Integer id){
       return clientService.findById(id);
    }

    @PutMapping("/update/client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Integer id, @RequestBody Client client){
        clientService.updateClient(id, client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Integer id){
       clientService.deleteClient(id);
    }
}
