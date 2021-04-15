package com.example.demo.controller;

import com.example.demo.dto.DashboardDto;
import com.example.demo.dto.DatoDto;
import com.example.demo.service.DatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/dato")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DatoControler {
    private DatoService datoService;

    @Autowired
    public DatoControler(DatoService datoService) {
        this.datoService = datoService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DatoDto> getdato(HttpServletRequest request) {
        return  datoService.getdatos();
    }
}
