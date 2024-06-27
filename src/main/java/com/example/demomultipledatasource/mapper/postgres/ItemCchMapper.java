package com.example.demomultipledatasource.mapper.postgres;

import com.example.demomultipledatasource.config.marker.ImsaMapper;
import com.example.demomultipledatasource.model.ItemCch;

@ImsaMapper
public interface ItemCchMapper {

    ItemCch postgresFindById(String headerChangeSeq);

}
