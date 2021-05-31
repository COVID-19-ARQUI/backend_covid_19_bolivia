package com.example.demo.dao;

import com.example.demo.domain.Persons;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonRepository {

    // creates a new user
    void createUser(Persons persons);

    //find user by username
    Persons findUserByUserName(String username);

    //find user by userid
    Persons findUserByUserId(Integer iduser);
}
