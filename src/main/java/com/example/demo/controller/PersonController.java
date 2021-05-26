package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.dto.LoginUserDto;
import com.example.demo.dto.RegisterUserDto;
import com.example.demo.dto.UserInfoDto;
import com.example.demo.service.PersonService;
import com.example.demo.service.TransactionService;
import com.example.demo.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/person")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonController {

    private final PersonService personService;
    private final TransactionService transactionService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

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

    @RequestMapping(value = "/user/info/{idUser}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserInfoDto getUserById(@PathVariable Integer idUser) {
        LOGGER.error(idUser.toString());
        return personService.getUserById(idUser);
    }

    @RequestMapping(value = "/user/info/email", params = {"email"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserInfoDto getUserByEmail(@RequestParam("email") String email) {
        LOGGER.error(email);
        return personService.getUserByEmail(email);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginUserDto loginUser(@RequestBody LoginUserDto user) {
        return personService.loginUser(user);
    }

}
