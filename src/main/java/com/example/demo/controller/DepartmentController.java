package com.example.demo.controller;

import com.example.demo.domain.Departments;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataSimpleDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.service.DataService;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartmentController {
    private final DataService dataService;
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DataService dataService, DepartmentService departmentService) {
        this.dataService = dataService;
        this.departmentService = departmentService;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Departments> getDepartments() {
        return departmentService.getDepartments();
    }

    @RequestMapping(value = "/all/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.getDepartmentsWithMunicipalities();
    }

    @RequestMapping(value = "single/list/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataDto> listDataByDepartment(@PathVariable("departmentId") Integer departmentId) {
        return dataService.listDataofDepartament(departmentId);
    }

    // General department data by department id.
    @RequestMapping(value = "general/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataDto> departmentStatistics(@PathVariable Integer departmentId) {
        return dataService.departmentStatistics(departmentId);
    }

    @RequestMapping(value = "/first/vaccinated/{idDepartment}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataDto getVaccinatedFirstDose(@PathVariable Integer idDepartment) {
        return dataService.getSumDataFirstVaccinated(idDepartment);
    }

    @RequestMapping(value = "/second/vaccinated/{idDepartment}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DataDto getVaccinatedSecondDose(@PathVariable Integer idDepartment) {
        return dataService.getSumDataSecondVaccinated(idDepartment);
    }


    @RequestMapping(value = "/departmentData/{departmentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> getDataByDepartmentsId(@PathVariable Integer departmentId) {
        return dataService.getDataByDepartmentsId(departmentId);
    }

    @RequestMapping(value = "datatype/{idDatatype}/department/{idDepartment}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> listSpecificDataByIdDepartment(@PathVariable Integer idDatatype, @PathVariable Integer idDepartment) {
        return dataService.listSpecificDataByIdDepartment(idDatatype, idDepartment);
    }
}
