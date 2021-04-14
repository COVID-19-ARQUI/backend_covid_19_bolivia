package com.example.demo.service;


import com.example.demo.dao.DashboardRepository;
import com.example.demo.dao.DatoRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dto.DashboardDto;
import com.example.demo.dto.DepartmentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {
    private DashboardRepository dashboardRepository;
    private DatoRepository datoRepository;
    private DepartmentRepository departmentRepository;
    //    private TransactionRepository transactionRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardService.class);

    @Autowired
    public DashboardService(DashboardRepository dashboardRepository, DatoRepository datoRepository, DepartmentRepository departmentRepository) {
        this.dashboardRepository = dashboardRepository;
        this.datoRepository = datoRepository;
        this.departmentRepository = departmentRepository;
    }


    public List<DashboardDto> getdashboard() {

        List<DepartmentDto> departments = departmentRepository.getDepartments();
        LOGGER.debug(departments.toString());
        List<DashboardDto> dashboardDepartments = departments.stream().map(departmentDto -> {
            DashboardDto dashboard = new DashboardDto();
            dashboard.setIdDepartment(departmentDto.getIdDepartment());
            dashboard.setDepartment(departmentDto.getDepartment());
            dashboard.setDatoDto(datoRepository.getDatos(departmentDto.getIdDepartment()));
            return dashboard;
        }).collect(Collectors.toList());
        LOGGER.debug(dashboardDepartments.toString());
        return dashboardDepartments;
    }
}
