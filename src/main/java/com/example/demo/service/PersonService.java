package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.domain.Persons;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.RegisterUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
@Service
public class PersonService implements UserDetailsService {

    PersonRepository personRepository;
    BCryptPasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

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
        persons.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        persons.setUrlPhoto(registerUserDto.getUrlPhoto());
        persons.setActive(1);
        persons.setRole("ROLE_USER");
        persons.setTxUserId(transaction.getTxUserId().toString());
        persons.setTxHost(transaction.getTxHost());
        persons.setTxDate(transaction.getTxDate());
        personRepository.createUser(persons);
        return registerUserDto;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persons userM = personRepository.findUserByUserName(username);
        if(userM != null){
            List<String> roles = new ArrayList<>();
            roles.add(userM.getRole());
            List<GrantedAuthority> authorities = roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role))
                    .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                    .collect(Collectors.toList());
            return new User(userM.getUsername(), userM.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("User '"+username+"' not found!");
        }
    }
}
