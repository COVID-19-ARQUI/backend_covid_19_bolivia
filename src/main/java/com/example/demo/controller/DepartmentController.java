package com.example.demo.controller;

import com.example.demo.domain.Departments;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataSimpleDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.service.DataService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartmentController {
    private DataService dataService;
    private TransactionService transactionService;
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DataService dataService, TransactionService transactionService, DepartmentService departmentService) {
        this.dataService = dataService;
        this.transactionService = transactionService;
        this.departmentService = departmentService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Departments> getDepartments() {
        return departmentService.getDepartments();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.getDepartmentsWithMunicipalities();
    }

    @RequestMapping(value = "single/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataDto> listDataByDepartment(@PathVariable("departmentId") Integer departmentId) {
        return dataService.listDataofDepartament(departmentId);
    }

    //sumdatos
    @RequestMapping(value = "/departmentgeneral/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataDto> sumadedatos(@PathVariable Integer departmentId) {
        return dataService.sumdatos(departmentId);
    }

    //vacunas
    @RequestMapping(value = "/departmentvacuna/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataDto vacunasdatos(@PathVariable Integer departmentId) {
        return dataService.getdatosvac1(departmentId);
    }

    @RequestMapping(value = "/departmentvacuna2/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataDto vacunas2datos(@PathVariable Integer departmentId) {
        return dataService.getdatosvac2(departmentId);
    }


    @RequestMapping(value = "/departmentData/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> getDataByDepartmentsId(@PathVariable Integer departmentId) {
        return dataService.getDataByDepartmentsId(departmentId);
    }
}
