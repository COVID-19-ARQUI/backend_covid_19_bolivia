package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DatoDto;
import com.example.demo.service.DatoService;
import com.example.demo.service.TransactionService;
import com.example.demo.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/data")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DatoControler {
    private DatoService datoService;
    private TransactionService transactionService;

    @Autowired
    public DatoControler(DatoService datoService, TransactionService transactionService) {
        this.datoService = datoService;
        this.transactionService = transactionService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DatoDto> getdato(HttpServletRequest request) {
        return datoService.getdatos();
    }

    @RequestMapping(value = "/new/single", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataDto pushSingleData(@RequestBody DataDto dataDto, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionService.createTransaction(transaction);
        return datoService.pushSingleData(dataDto);
    }


}
