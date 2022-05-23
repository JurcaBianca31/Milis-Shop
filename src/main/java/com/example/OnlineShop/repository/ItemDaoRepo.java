package com.example.OnlineShop.repository;

import com.example.OnlineShop.model.ItemDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDaoRepo extends JpaRepository<ItemDao, Long> {
 ItemDao findByName(String itemName);
}
