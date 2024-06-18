package com.example.demomultipledatasource.service;

import com.example.demomultipledatasource.mapper.UserMapper;
import com.example.demomultipledatasource.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    private final UserMapper userMapper;

    public HelloService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String getHelloMessage() {
        return "Hello";
    }

    public User findById() {
        return userMapper.findById(1L);
    }

    public List<User> findAll() {
        System.out.println("[KJH] Service - findAll");
        return userMapper.findAll();
    }

}
