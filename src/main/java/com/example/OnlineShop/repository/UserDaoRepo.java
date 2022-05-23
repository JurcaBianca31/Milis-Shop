package com.example.OnlineShop.repository;

import com.example.OnlineShop.model.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDaoRepo extends JpaRepository<UserDao, Long> {
     Optional<UserDao> findByUserName(String userName);

}
