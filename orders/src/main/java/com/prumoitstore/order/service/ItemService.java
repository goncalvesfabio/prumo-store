package com.prumoitstore.order.service;

import com.prumoitstore.order.domain.Item;
import com.prumoitstore.order.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }


    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item updateItem(Item item, Integer id) {
        Item existItem = itemRepository.findById(id).get();
        BeanUtils.copyProperties(item, existItem, "id");
        return itemRepository.save(existItem);
    }
}
