package com.example.OnlineShop.api;

import com.example.OnlineShop.Exceptions.PasswordInvalidException;
import com.example.OnlineShop.Exceptions.UsernameInvalidException;
import com.example.OnlineShop.model.NewUser;
import com.example.OnlineShop.model.UserDao;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface UserDaoController {

    @GetMapping("/UserDao/{userName}")
    UserDao getUserByUserName(@PathVariable String userName);

    @DeleteMapping("/deleteUserDao/{userName}")
    void deleteUserByUserName(@PathVariable String userName);

    @PutMapping("/updateUserDao/{id}")
    UserDao updateUserDao(@RequestBody UserDao userDao,
                          @PathVariable Long id);

    @PostMapping("/register")
    void register(@RequestBody NewUser newUser) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException;

    @GetMapping("/login")
    Boolean login(@RequestBody NewUser newUser) throws InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, UsernameInvalidException, PasswordInvalidException;

}
