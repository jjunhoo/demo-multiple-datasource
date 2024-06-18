package com.example.demomultipledatasource.mapper;

import com.example.demomultipledatasource.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User findById(Long id);

    List<User> findAll();

}
