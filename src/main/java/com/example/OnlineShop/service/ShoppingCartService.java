package com.example.OnlineShop.service;

import com.example.OnlineShop.model.UserDao;
import com.example.OnlineShop.model.ItemDao;
import com.example.OnlineShop.repository.ShoppingCartRepo;
import com.example.OnlineShop.repository.ItemDaoRepo;
import com.example.OnlineShop.repository.UserDaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;
    @Autowired
    private ItemDaoRepo itemDaoRepo;
    @Autowired
    private UserDaoRepo userDaoRepo;

    
    public void addItemToUser(String userName, String itemName){
       Optional<UserDao> userDao = userDaoRepo.findByUserName(userName);
       ItemDao itemDao = itemDaoRepo.findByName(itemName);
       userDao.get().getShoppingCart().getItems().add(itemDao);
       setPrice(userDao.get());
       setQuantity(userDao.get());
       itemDaoRepo.save(itemDao);
       shoppingCartRepo.save(userDao.get().getShoppingCart());
    }

    public Double calculateTotalValueOfItems(List<ItemDao> items){
        double subTotal = 0;
        for(ItemDao item : items){
            subTotal += item.getPrice();
        }
        return subTotal;
    }

    public void setPrice(UserDao userDao){
        List<ItemDao> items = userDao.getShoppingCart().getItems();
        double total = calculateTotalValueOfItems(items);
        userDao.getShoppingCart().setSubTotal(total);
    }

    public void setQuantity(UserDao userDao){
        int quantity = userDao.getShoppingCart().getItems().size();
        userDao.getShoppingCart().setQuantity(quantity);
    }

}
