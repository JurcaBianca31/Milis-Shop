package com.example.OnlineShop.api;


import com.example.OnlineShop.model.ItemDao;
import org.springframework.web.bind.annotation.*;

public interface ItemDaoController {

    @GetMapping("/item/{id}")
    ItemDao getItemById(@PathVariable Long id);

    @DeleteMapping("/deleteItem/{id}")
    void deleteItem(@PathVariable Long id);

    @PutMapping("/updateItem/{id}")
    ItemDao updateItem(@RequestBody ItemDao itemDao,
                       @PathVariable Long id);

    @PostMapping("/createItem")
    void createItem(@RequestBody ItemDao itemDao);

    @PostMapping("/addItem/{userName}/{itemName}")
    void addItemToUser(@PathVariable String userName,
                       @PathVariable String itemName);
}
