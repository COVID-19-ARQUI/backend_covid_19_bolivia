package com.example.demo.controller;

import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataSimpleDto;
import com.example.demo.dto.MunicipalityDataDto;
import com.example.demo.dto.MunicipalityDto;
import com.example.demo.service.MunicipalitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/municipalities")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MunicipalityController {
    private final MunicipalitiesService municipalitiesService;

    @Autowired
    public MunicipalityController(MunicipalitiesService municipalitiesService) {
        this.municipalitiesService = municipalitiesService;
    }

    @RequestMapping(value = "/{idMunicipality}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MunicipalityDataDto> getMunicipalityData(@PathVariable Integer idMunicipality) {
        return municipalitiesService.getMunicipalityById(idMunicipality);
    }

    @RequestMapping(value = "/{idMunicipality}/datatype/{idDatatype}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataSimpleDto> getDataByIdMunicipality(@PathVariable Integer idDatatype, @PathVariable Integer idMunicipality) {
        return municipalitiesService.getDataByIdMunicipality(idDatatype, idMunicipality);
    }

    @RequestMapping(value = "/list/department/{idDepartment}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MunicipalityDto> getMunicipalities(@PathVariable Integer idDepartment) {
        return municipalitiesService.getMunicipalitiesList(idDepartment);
    }  // TODO: ENHANCE THIS

    @RequestMapping(value = "general/{idMunicipality}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataDto> departmentStatistics(@PathVariable Integer idMunicipality) {
        return municipalitiesService.municipalityStatistics(idMunicipality);
    }

    @RequestMapping(value = "/department/{idDepartment}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MunicipalityDataDto> getMunicipalityDataByDepartment(@PathVariable Integer idDepartment) {
        return municipalitiesService.getMunicipalityByIdDepartment(idDepartment);
    }
}
