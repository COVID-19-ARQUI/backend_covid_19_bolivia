package com.example.demo.controller;

import com.example.demo.dto.DashboardDto;
import com.example.demo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/dashboards")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardControler {
    private DashboardService dashboardService;
//    private TransactionService transactionService;

    @Autowired
    public DashboardControler(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DashboardDto> getDashboard(HttpServletRequest request) {
        return dashboardService.getdashboard();
    }



}
