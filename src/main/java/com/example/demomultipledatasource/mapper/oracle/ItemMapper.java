package com.example.demomultipledatasource.mapper.oracle;

import com.example.demomultipledatasource.config.marker.SsgMapper;
import com.example.demomultipledatasource.model.Item;

@SsgMapper
public interface ItemMapper {

    Item oracleFindById(String itemId);

}
