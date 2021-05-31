package com.example.demo.service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.domain.Persons;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.RegisterUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    public PersonService(PersonRepository personRepository, BCryptPasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterUserDto createUser(RegisterUserDto registerUserDto, Transaction transaction) {
        LOGGER.warn(registerUserDto.toString());
        Persons persons = new Persons();
        persons.setUsername(registerUserDto.getUsername());
        persons.setName(registerUserDto.getName());
        persons.setSurname(registerUserDto.getSurname());
        persons.setEmail(registerUserDto.getEmail());
        persons.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        persons.setUrlPhoto("");
        persons.setRole("user");
        persons.setActive(1);
        persons.setTxUserId(transaction.getTxUserId().toString());
        persons.setTxHost(transaction.getTxHost());
        persons.setTxDate(transaction.getTxDate());
        personRepository.createUser(persons);
        return registerUserDto;
    }
    public Persons getUserById(Integer userid){
        return personRepository.findUserByUserId(userid);
    }


}
