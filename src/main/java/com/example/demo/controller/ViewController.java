package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.dto.DashboardDataDto;
import com.example.demo.dto.ViewDto;
import com.example.demo.service.ViewService;
import com.example.demo.service.TransactionService;
import com.example.demo.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/view")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ViewController {
    private final ViewService viewService;
    private final TransactionService transactionService;

    @Autowired
    public ViewController(ViewService viewService, TransactionService transactionService) {
        this.viewService = viewService;
        this.transactionService = transactionService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DashboardDataDto> getDashboard() {
        return viewService.getDashboard();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ViewDto addNewDashboard(@RequestBody ViewDto dashboard, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionService.createTransaction(transaction);
        return viewService.addNewDashboard(dashboard, transaction);
    }

    @RequestMapping(value = "/{idUser}/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ViewDto> getDashboardsByUser(@PathVariable Integer idUser) {
        return viewService.getDashboardsByUser(idUser);
    }

    @RequestMapping(value = "/user/{idUser}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateDashboard(@PathVariable Integer idUser, @RequestBody ViewDto dashboard) {
        viewService.updateDashboard(idUser, dashboard);
    }


}
