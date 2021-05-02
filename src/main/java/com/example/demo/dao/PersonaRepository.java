package com.example.demo.dao;


import com.example.demo.domain.Persons;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonaRepository {
    //
    public void createUser(Persons persons);
}
