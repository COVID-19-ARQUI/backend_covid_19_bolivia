package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DatoDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.*;
import com.example.demo.service.DataService;
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
public class DataController {
    private final DataService dataService;
    private final TransactionService transactionService;

    @Autowired
    public DataController(DataService dataService, TransactionService transactionService) {
        this.dataService = dataService;
        this.transactionService = transactionService;
    }

    @RequestMapping(value = "/department/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DatoDto> findVehiclesByCompany(@PathVariable Integer departmentId) {
        return dataService.listDataofDepartament(departmentId);
    }

    //sumdatos
    @RequestMapping(value = "/departmentgeneral/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DatoDto> sumadedatos(@PathVariable Integer departmentId) {
        return dataService.sumdatos(departmentId);
    }

    //vacunas
    @RequestMapping(value = "/departmentvacuna/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DatoDto vacunasdatos(@PathVariable Integer departmentId) {
        return dataService.getdatosvac1(departmentId);
    }

    @RequestMapping(value = "/departmentvacuna2/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DatoDto vacunas2datos(@PathVariable Integer departmentId) {
        return dataService.getdatosvac2(departmentId);
    }

    @RequestMapping(value = "/new/single", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataDto pushSingleData(@RequestBody DataDto dataDto, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionService.createTransaction(transaction);
        return dataService.pushSingleData(dataDto, transaction);
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDto> getAllDepartments() {
        return dataService.getDepartments();
    }

    @RequestMapping(value = "/departmentData/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDataDto> getDataByDepartmentsId(@PathVariable Integer departmentId) {
        return dataService.getDataByDepartmentsId(departmentId);
    }

    @RequestMapping(value = "/dataRecent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DateCovidDto> mostRecentDateOfCovidData() {
        return dataService.mostRecentDateOfCovidData();
    }

    @RequestMapping(value = "/dataOfDepartmentAndTypeDate/{tipoDatoId}/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataCovidDepartmentDto> listDataOfDepartmentAndTypeDate(@PathVariable Integer tipoDatoId, @PathVariable Integer departmentId) {
        return dataService.listDataOfDepartmentAndTypeDate(tipoDatoId, departmentId);
    }


    @RequestMapping(value = "/Bolivia", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DatoDto> getGeneral() {
        return dataService.getdatos();
    }

    @RequestMapping(value = "/municipios/{tipoDatoId}/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataCovidMunicipioDto> getDataByMunicipioId(@PathVariable Integer tipoDatoId, @PathVariable Integer departmentId) {
        return dataService.getDataByMunicipioId(tipoDatoId, departmentId);
    }

}
