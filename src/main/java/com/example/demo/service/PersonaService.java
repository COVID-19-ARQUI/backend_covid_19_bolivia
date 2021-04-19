package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.domain.Persona;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.RegisterUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public RegisterUserDto createUser(RegisterUserDto registerUserDto, Transaction transaction){
        Persona persona = new Persona();
        persona.setNicknameUser(registerUserDto.getNicknameUser());
        persona.setName(registerUserDto.getName());
        persona.setSecondName(registerUserDto.getSecondName());
        persona.setLastName(registerUserDto.getLastName());
        persona.setSecondLastName(registerUserDto.getSecondLastName());
        persona.setEmail(registerUserDto.getEmail());
        persona.setPassword(registerUserDto.getPassword());
        persona.setTxUser(transaction.getTxUserUd().toString());
        persona.setTxHost(transaction.getTxHost());
        persona.setTxDate(transaction.getTxDate());
        personaRepository.createUser(persona);
        return registerUserDto;
    }
}
