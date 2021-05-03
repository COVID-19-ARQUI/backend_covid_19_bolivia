package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.domain.Persons;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonaRepository personaRepository;

    @Autowired
    public PersonService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public RegisterUserDto createUser(RegisterUserDto registerUserDto, Transaction transaction) {
        Persons persons = new Persons();
        persons.setNickname(registerUserDto.getNicknameUser());
        persons.setFirstName(registerUserDto.getName());
        persons.setSecondName(registerUserDto.getSecondName());
        persons.setFirstLastName(registerUserDto.getLastName());
        persons.setSecondLastName(registerUserDto.getSecondLastName());
        persons.setEmail(registerUserDto.getEmail());
        persons.setPassword(registerUserDto.getPassword());
        persons.setTxUserId(transaction.getTxUserId().toString());
        persons.setTxHost(transaction.getTxHost());
        persons.setTxDate(transaction.getTxDate());
        personaRepository.createUser(persons);
        return registerUserDto;
    }
}