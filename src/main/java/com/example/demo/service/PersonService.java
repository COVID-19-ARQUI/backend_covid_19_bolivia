package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.domain.Persons;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.RegisterUserDto;
import com.example.demo.dto.UserInfoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonRepository personRepository;
    TransactionRepository transactionRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    public PersonService(PersonRepository personRepository, TransactionRepository transactionRepository) {
        this.personRepository = personRepository;
        this.transactionRepository = transactionRepository;
    }


    public UserInfoDto createUser(RegisterUserDto registerUserDto, Transaction transaction) {
        Persons persons = new Persons();
        persons.setNickname(registerUserDto.getNickname());
        persons.setFirstName(registerUserDto.getFirstName());
        persons.setSecondName(registerUserDto.getSecondName());
        persons.setFirstLastName(registerUserDto.getFirstLastName());
        persons.setSecondLastName(registerUserDto.getSecondLastName());
        persons.setEmail(registerUserDto.getEmail());
        persons.setPassword(registerUserDto.getPassword());
        persons.setUrlPhoto(registerUserDto.getUrlPhoto());
        persons.setActive(1);
        persons.setTxUserId(transaction.getTxUserId().toString());
        persons.setTxHost(transaction.getTxHost());
        persons.setTxDate(transaction.getTxDate());
        LOGGER.warn(persons.toString());
        personRepository.createUser(persons);
        return  personRepository.getUserById(transactionRepository.getLastInsertId());
    }

    public UserInfoDto getUserById(Integer idUser) {
        return personRepository.getUserById(idUser);
    }

    public UserInfoDto getUserByEmail(String email) {
        return personRepository.getUserByEmail(email);
    }
}
