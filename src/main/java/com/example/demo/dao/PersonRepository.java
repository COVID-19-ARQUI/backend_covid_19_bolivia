package com.example.demo.dao;


import com.example.demo.domain.Persons;
import com.example.demo.dto.UserInfoDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonRepository {
    //
    void createUser(Persons persons);

    // Get user info by user id
    UserInfoDto getUserById(Integer idUser);

    // Get user info by email
    UserInfoDto getUserByEmail(String email);
}
