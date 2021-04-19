package com.example.demo.controller;

import com.example.demo.dto.DashboardDto;
import com.example.demo.dto.MunicipalityDataDto;
import com.example.demo.service.DashboardService;
import com.example.demo.service.MunicipalitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/municipalities")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MunicipalityController {
    private MunicipalitiesService municipalitiesService;
//    private TransactionService transactionService;

    @Autowired
    public MunicipalityController(MunicipalitiesService municipalitiesService) {
        this.municipalitiesService = municipalitiesService;
    }

    @RequestMapping(value = "/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MunicipalityDataDto> getMunicipatilyData(@PathVariable Integer departmentId) {
        return municipalitiesService.getMunicipalityByDepartment(departmentId);
    }


}
