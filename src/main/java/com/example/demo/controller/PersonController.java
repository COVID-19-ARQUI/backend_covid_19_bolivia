package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.dto.RegisterUserDto;
import com.example.demo.service.PersonService;
import com.example.demo.service.TransactionService;
import com.example.demo.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private PersonService personService;
    private TransactionService transactionService;

    @Autowired
    public PersonController(PersonService personService, TransactionService transactionService) {
        this.personService = personService;
        this.transactionService = transactionService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisterUserDto createUser(@RequestBody RegisterUserDto registerUserDto, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionService.createTransaction(transaction);
        return personService.createUser(registerUserDto, transaction);
    }

}
