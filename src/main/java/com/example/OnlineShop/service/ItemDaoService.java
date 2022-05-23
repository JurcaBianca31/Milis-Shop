package com.example.OnlineShop.service;

import com.example.OnlineShop.model.ItemDao;
import com.example.OnlineShop.model.NewItem;
import com.example.OnlineShop.repository.ItemDaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemDaoService {
    @Autowired
    ItemDaoRepo itemDaoRepo;

    public ItemDao getItemById(Long id) {
        return itemDaoRepo.findById(id).get();
    }

    public void createItem(ItemDao itemDao){
        itemDaoRepo.save(itemDao);
    }

    public void saveItem(NewItem newItem) {
        itemDaoRepo.save(convertToItemDao(newItem));
    }

    public void deleteItem(Long id) {
        ItemDao itemDao = getItemById(id);
        itemDaoRepo.deleteById(id);
    }

    public ItemDao updateItem(ItemDao itemDao, Long id) {
        ItemDao existItemDao = itemDaoRepo.findById(id).get();
        existItemDao.setName(itemDao.getName());
        return itemDaoRepo.save(existItemDao);
    }

    public ItemDao convertToItemDao(NewItem newItem){
        ItemDao itemDao = new ItemDao();
        itemDao.setName(newItem.getName());
        itemDao.setPrice(newItem.getPrice());
        return itemDao;
    }
}
