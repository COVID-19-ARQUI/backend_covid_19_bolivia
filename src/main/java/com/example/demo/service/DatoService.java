package com.example.demo.service;

import com.example.demo.dao.DatoRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DatoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatoService {
    private DatoRepository datoRepository;
    private DepartmentRepository departmentRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardService.class);

    @Autowired
    public DatoService(DatoRepository datoRepository, DepartmentRepository departmentRepository) {
        this.datoRepository = datoRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<DatoDto> getdatos() {
        List<DatoDto> datoDtoList = datoRepository.getDatosGenerales();
        return datoDtoList;
    }

    public DataDto pushSingleData(DataDto dataDto) {
        return dataDto;
    }
}
