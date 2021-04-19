package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.dto.*;
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

    @RequestMapping(value = "/department/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DatoDto> findVehiclesByCompany(HttpServletRequest request, @PathVariable Integer departmentId) {
        List<DatoDto> vehicleListDriver=datoService.listDataofDepartament(departmentId);
        return vehicleListDriver;
    }
//sumdatos
    @RequestMapping(value = "/departmentgeneral/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DatoDto> sumadedatos(HttpServletRequest request, @PathVariable Integer departmentId) {
        List<DatoDto> vehicleListDriver=datoService.sumdatos(departmentId);
        return vehicleListDriver;
    }
    @RequestMapping(value = "/new/single", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataDto pushSingleData(@RequestBody DataDto dataDto, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionService.createTransaction(transaction);
        return datoService.pushSingleData(dataDto, transaction);
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDto> getAllDepartments() {
        return datoService.getDepartments();
    }

    @RequestMapping(value = "/departmentData/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDataDto> getDataByDepartmentsId(HttpServletRequest request, @PathVariable Integer departmentId) {
        List<DepartmentDataDto> listDepartment=datoService.getDataByDepartmentsId(departmentId);
        return listDepartment;
    }
    @RequestMapping(value = "/dataRecent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DateCovidDto> mostRecentDateOfCovidData() {
        return datoService.mostRecentDateOfCovidData();
    }


}
