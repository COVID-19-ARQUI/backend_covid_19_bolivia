package com.example.demo.controller;

import com.example.demo.domain.Dashboard;
import com.example.demo.dto.DashboardDataDto;
import com.example.demo.dto.DashboardDto;
import com.example.demo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dashboard")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardController {
    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DashboardDataDto> getDashboard() {
        return dashboardService.getDashboard();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Dashboard addNewDashboard(@RequestBody Dashboard dashboard) {
        return dashboardService.addNewDashboard(dashboard);
    }

    @RequestMapping(value = "/{idUser}/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DashboardDto> getDashboardsByUser(@PathVariable Integer idUser) {
        return dashboardService.getDashboardsByUser(idUser);
    }

    @RequestMapping(value = "/{idDashboard}/user/{idUser}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public Dashboard updateDashboard(@PathVariable Integer idDashboard, @PathVariable Integer idUser) {
        return dashboardService.updateDashboard(idDashboard, idUser);
    }
}
