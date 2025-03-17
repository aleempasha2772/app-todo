package com.example.todo_app.Service;


import com.example.todo_app.Model.Item;
import com.example.todo_app.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item saveItem(Item item){
        itemRepository.save(item);
        return item;
    }

    public List<Item> getAllItems(){

        return itemRepository.findAll();
    }

    public Item getItemById(int id){
        return itemRepository.findById(id).get();
    }

    public void deleteItemById(int id){
        itemRepository.deleteById(id);
    }



}
