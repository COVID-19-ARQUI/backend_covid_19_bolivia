package com.example.demo.dao;

import com.example.demo.domain.Transaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionDao {
    //
    public Integer create(Transaction transaction);

    //
    public Integer getLastInsertId();

}