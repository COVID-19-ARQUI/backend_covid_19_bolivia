package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.domain.Persons;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.RegisterUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonRepository personRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public RegisterUserDto createUser(RegisterUserDto registerUserDto, Transaction transaction) {
        Persons persons = new Persons();
        persons.setUsername(registerUserDto.getNickname());
        persons.setName(registerUserDto.getFirstName());
        persons.setSurname(registerUserDto.getSecondName());
        persons.setEmail(registerUserDto.getEmail());
        persons.setPassword(registerUserDto.getPassword());
        persons.setUrlPhoto(registerUserDto.getUrlPhoto());
        persons.setActive(1);
        persons.setTxUserId(transaction.getTxUserId().toString());
        persons.setTxHost(transaction.getTxHost());
        persons.setTxDate(transaction.getTxDate());
        LOGGER.warn(persons.toString());
        personRepository.createUser(persons);
        return registerUserDto;
    }
}
