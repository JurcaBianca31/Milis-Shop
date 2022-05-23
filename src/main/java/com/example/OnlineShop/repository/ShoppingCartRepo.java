package com.example.OnlineShop.repository;

import com.example.OnlineShop.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Long> {

}
