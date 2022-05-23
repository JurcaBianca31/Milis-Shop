package com.example.OnlineShop.api;

import com.example.OnlineShop.Exceptions.PasswordInvalidException;
import com.example.OnlineShop.Exceptions.UsernameInvalidException;
import com.example.OnlineShop.model.NewUser;
import com.example.OnlineShop.model.UserDao;
import com.example.OnlineShop.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
public class UserDaoControllerImpl implements UserDaoController {

    @Autowired
    private UserDaoService service;


    @Override
    public UserDao getUserByUserName(String userName) {
       return service.getUserByUserName(userName);
    }

    @Override
    public void deleteUserByUserName(String userName) {
        service.deleteUserByUserName(userName);

    }

    @Override
    public UserDao updateUserDao(UserDao userDao, Long id) {
        return service.updateUserDao(userDao, id);
    }

    @Override
    public void register(NewUser newUser) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        service.saveUser(newUser);
    }

    @Override
    public Boolean login(NewUser newuser) throws InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, UsernameInvalidException, PasswordInvalidException {
        return service.login(newuser.getUserName(), newuser.getPassword());
    }
}
