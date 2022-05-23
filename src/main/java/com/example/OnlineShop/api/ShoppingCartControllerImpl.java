package com.example.OnlineShop.api;

import com.example.OnlineShop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartControllerImpl implements ShoppingCartController{

    @Autowired
    private ShoppingCartService service;


}
