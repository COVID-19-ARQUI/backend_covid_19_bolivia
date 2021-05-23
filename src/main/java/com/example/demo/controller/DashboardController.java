package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.dto.DashboardDataDto;
import com.example.demo.dto.DashboardDto;
import com.example.demo.service.DashboardService;
import com.example.demo.service.TransactionService;
import com.example.demo.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/dashboard")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardController {
    private final DashboardService dashboardService;
    private final TransactionService transactionService;

    @Autowired
    public DashboardController(DashboardService dashboardService, TransactionService transactionService) {
        this.dashboardService = dashboardService;
        this.transactionService = transactionService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DashboardDataDto> getDashboard() {
        return dashboardService.getDashboard();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DashboardDto addNewDashboard(@RequestBody DashboardDto dashboard, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionService.createTransaction(transaction);
        return dashboardService.addNewDashboard(dashboard, transaction);
    }

    @RequestMapping(value = "/{idUser}/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DashboardDto> getDashboardsByUser(@PathVariable Integer idUser) {
        return dashboardService.getDashboardsByUser(idUser);
    }

    @RequestMapping(value = "/user/{idUser}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateDashboard(@PathVariable Integer idUser, @RequestBody DashboardDto dashboard) {
        dashboardService.updateDashboard(idUser, dashboard);
    }
}
