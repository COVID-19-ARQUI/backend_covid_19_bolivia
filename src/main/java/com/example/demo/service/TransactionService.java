package com.example.demo.service;

import com.example.demo.dao.TransactionRepository;
import com.example.demo.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction (Transaction transaction){
        this.transactionRepository.create(transaction);
        Integer lastPrimaryKey= this.transactionRepository.getLastInsertId();
        transaction.setTxId(lastPrimaryKey);
        return transaction;
    }
}
