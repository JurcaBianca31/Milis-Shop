package com.example.OnlineShop.service;

import com.example.OnlineShop.Exceptions.PasswordInvalidException;
import com.example.OnlineShop.Exceptions.UsernameInvalidException;
import com.example.OnlineShop.Security.PasswordEncryption;
import com.example.OnlineShop.model.NewUser;
import com.example.OnlineShop.model.ShoppingCart;
import com.example.OnlineShop.model.UserDao;
import com.example.OnlineShop.repository.UserDaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;


@Service
public class UserDaoService {
    @Autowired
    UserDaoRepo userDaoRepo;
    @Autowired
    PasswordEncryption passwordEncryption;


    public UserDao getUserByUserName(String userName) {
        return userDaoRepo.findByUserName(userName).get();
    }

    public void saveUser(NewUser newUser) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        userDaoRepo.save(convertToUserDao(newUser));
    }

    public void deleteUserByUserName(String userName) {
        Optional<UserDao> userDao = userDaoRepo.findByUserName(userName);
        userDaoRepo.delete(userDao.get());
    }

    public UserDao updateUserDao(UserDao userDao, Long id) {
        UserDao existUserDao = userDaoRepo.findById(id).get();
        return userDaoRepo.save(existUserDao);
    }

    public UserDao convertToUserDao(NewUser newUser) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        UserDao userDao = new UserDao();
        userDao.setFirstName(newUser.getFirstName());
        userDao.setLastName(newUser.getLastName());
        userDao.setEmail(newUser.getEmail());
        userDao.setUserName(newUser.getUserName());
        userDao.setAddress(newUser.getAddress());
        userDao.setPassword(passwordEncryption.encrypt(newUser.getPassword()));
        userDao.setPhone(newUser.getPhone());
        userDao.setShoppingCart(new ShoppingCart());
        return userDao;
    }

    public Boolean login(String userName, String password) throws InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, UsernameInvalidException, PasswordInvalidException {
        Optional<UserDao> userDao = userDaoRepo.findByUserName(userName);
        if (userDao.isPresent()) {
            String userPass = passwordEncryption.decrypt(userDao.get().getPassword());
            if (userPass.equals(password)) {
                return true;
            }
            throw new PasswordInvalidException("This password is not valid!");
        }
        throw new UsernameInvalidException("This username does not exist!");
    }

}
