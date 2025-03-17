package com.example.todo_app.Controller;


import com.example.todo_app.Model.Item;
import com.example.todo_app.Repository.ItemRepository;
import com.example.todo_app.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("to-do/api/v1")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;


    @GetMapping()
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> list = itemService.getAllItems();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Item> saveItem(@RequestBody  Item item) {
        return ResponseEntity.ok(itemService.saveItem(item));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") int id) {
        Item item = new Item();
        if(getAllItems()!=null) {
            item = itemService.getItemById(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/count")
    public ResponseEntity<Integer> getTotalItemsCount() {
        int totalItems = (int) itemRepository.count();
        return new ResponseEntity<>(totalItems, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable("id") int id) {
        itemService.deleteItemById(id);
        return new ResponseEntity<>("Item deleted", HttpStatus.OK);

    }




}
