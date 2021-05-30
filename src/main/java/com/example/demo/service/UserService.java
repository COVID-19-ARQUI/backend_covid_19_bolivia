package com.example.demo.service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.domain.Persons;
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
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final PersonRepository personRepository;

    @Autowired
    public UserService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.error(username);
        Persons userM = personRepository.findUserByUserName(username);
        if (userM != null) {
            List<String> roles = new ArrayList<>();
            roles.add(userM.getRole());
            List<GrantedAuthority> authorities = roles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .peek(authority -> logger.info("Role: " + authority.getAuthority()))
                    .collect(Collectors.toList());
            return new User(userM.getUsername(), userM.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("User '" + username + "' not found!");
        }
    }
}
