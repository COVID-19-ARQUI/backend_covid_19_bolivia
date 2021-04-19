package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.RegisterUserDto;
import com.example.demo.service.DatoService;
import com.example.demo.service.PersonaService;
import com.example.demo.service.TransactionService;
import com.example.demo.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/persona")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonaController {

    private PersonaService personaService;
    private TransactionService transactionService;

    @Autowired
    public PersonaController(PersonaService personaService, TransactionService transactionService) {
        this.personaService = personaService;
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisterUserDto createUser(@RequestBody RegisterUserDto registerUserDto, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionService.createTransaction(transaction);
        return personaService.createUser(registerUserDto, transaction);
    }


}
