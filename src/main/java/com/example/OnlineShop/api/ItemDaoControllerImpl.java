package com.example.OnlineShop.api;

import com.example.OnlineShop.model.ItemDao;
import com.example.OnlineShop.service.ItemDaoService;
import com.example.OnlineShop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemDaoControllerImpl implements ItemDaoController {

    @Autowired
    private ItemDaoService service;
    @Autowired
    private ShoppingCartService shoppingService;


    @Override
    public ItemDao getItemById(Long id) {
        return service.getItemById(id);
    }


    @Override
    public void deleteItem(Long id) {
        service.deleteItem(id);

    }

    @Override
    public ItemDao updateItem(ItemDao itemDao, Long id) {
        return service.updateItem(itemDao, id);
    }

    @Override
    public void createItem(ItemDao itemDao) {
        service.createItem(itemDao);
    }

    @Override
    public void addItemToUser(String userName, String itemName) {
        shoppingService.addItemToUser(userName, itemName);
    }
}
