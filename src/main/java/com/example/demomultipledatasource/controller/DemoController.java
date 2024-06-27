package com.example.demomultipledatasource.controller;

import com.example.demomultipledatasource.model.Item;
import com.example.demomultipledatasource.model.ItemCch;
import com.example.demomultipledatasource.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoService helloService;

    @Autowired
    public DemoController(DemoService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return helloService.getHelloMessage();
    }

    @GetMapping("/oracle")
    public Item oracleFindById() {
        System.out.println("[multisource] Controller - oracle");
        return helloService.oracleFindById();
    }

    @GetMapping("/postgres")
    public ItemCch postgresFindById() {
        System.out.println("[multisource] Controller - postgres");
        return helloService.postgresFindById();
    }
}