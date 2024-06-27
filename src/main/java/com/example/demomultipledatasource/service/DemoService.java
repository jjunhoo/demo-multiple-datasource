package com.example.demomultipledatasource.service;

import com.example.demomultipledatasource.mapper.oracle.ItemMapper;
import com.example.demomultipledatasource.mapper.postgres.ItemCchMapper;
import com.example.demomultipledatasource.model.Item;
import com.example.demomultipledatasource.model.ItemCch;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DemoService {

    private final ItemMapper itemMapper;
    private final ItemCchMapper itemCchMapper;

    public String getHelloMessage() {
        return "Hello";
    }
    
    // Oracle - ITEM (1000506515137)
    public Item oracleFindById() {
        return itemMapper.oracleFindById("1000506515137");
    }

    /**
     * Postgres - ITEM_CCH
     * - ITEM_ID : 1000520689527
     * - HEADER_CHANGE_SEQ : 20240504232932000000000000000000257
     * - HEADER_OPERATION : INSERT
     *
     * @return
     */
    public ItemCch postgresFindById() {
        return itemCchMapper.postgresFindById("20240504232932000000000000000000257");
    }
}
