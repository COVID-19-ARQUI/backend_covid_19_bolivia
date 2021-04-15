package com.example.demo.dao;

import com.example.demo.domain.Transaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionRepository {
    // Create Transaction
    public void create(Transaction transaction);

    // Get last insert id
    public Integer getLastInsertId();
}
