package com.example.demomultipledatasource.controller;

import com.example.demomultipledatasource.model.User;
import com.example.demomultipledatasource.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return helloService.getHelloMessage();
    }

    @GetMapping("/user")
    public User findById() {
        return helloService.findById();
    }

    @GetMapping("/users")
    public List<User> findAll() {
        System.out.println("[KJH] Controller - findAll");
        return helloService.findAll();
    }
}