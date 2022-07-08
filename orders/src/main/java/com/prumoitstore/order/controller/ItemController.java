package com.prumoitstore.order.controller;

import com.prumoitstore.order.domain.Item;
import com.prumoitstore.order.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@AllArgsConstructor
public class ItemController {

    private ItemService itemService;

    @PostMapping("/items")
    public ResponseEntity<Item> saveItem(@RequestBody Item item){
        itemService.addItem(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItem(){
        List<Item> items =  itemService.findAll();
        return new ResponseEntity<List<Item>>(items, HttpStatus.OK);
    }
    @PutMapping("/items/{id}")
    public ResponseEntity<Item> update(@RequestBody Item item, @PathVariable Integer id){
        itemService.updateItem(item, id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable Integer id){
        itemService.deleteItemId(id);
        return "Item removed!!" + id;
    }
}
