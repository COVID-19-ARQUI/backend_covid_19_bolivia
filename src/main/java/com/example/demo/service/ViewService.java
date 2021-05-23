package com.example.demo.service;


import com.example.demo.dao.ViewRepository;
import com.example.demo.dao.DataRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.TransactionRepository;
import com.example.demo.domain.Views;
import com.example.demo.domain.Departments;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.DashboardDataDto;
import com.example.demo.dto.ViewDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViewService {
    private final ViewRepository viewRepository;
    private final DataRepository dataRepository;
    private final DepartmentRepository departmentRepository;
    private final TransactionRepository transactionRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ViewService.class);

    @Autowired
    public ViewService(ViewRepository viewRepository, DataRepository dataRepository, DepartmentRepository departmentRepository, TransactionRepository transactionRepository) {
        this.viewRepository = viewRepository;
        this.dataRepository = dataRepository;
        this.departmentRepository = departmentRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<DashboardDataDto> getDashboard() {
        List<Departments> departments = departmentRepository.getDepartments();
//        LOGGER.error(departments.toString());
        List<DashboardDataDto> dashboardDepartments = departments.stream().map(departmentDto -> {
            DashboardDataDto dashboard = new DashboardDataDto();
            dashboard.setIdDepartment(departmentDto.getIdDepartment());
            dashboard.setDepartment(departmentDto.getDepartment());
            dashboard.setDataDto(dataRepository.getData(departmentDto.getIdDepartment()));
            return dashboard;
        }).collect(Collectors.toList());
//        LOGGER.debug(dashboardDepartments.toString());
        return dashboardDepartments;
    }

    public List<ViewDto> getDashboardsByUser(Integer idUser) {
        return viewRepository.getDashboardsByUserId(idUser);
    }

    public ViewDto addNewDashboard(ViewDto viewDto, Transaction transaction) {
        Views views = new Views();
        views.setName(viewDto.getName());
        views.setActive(1);
        views.setIdUser(viewDto.getIdUser());
        views.setTxUserId(transaction.getTxUserId());
        views.setTxDate(transaction.getTxDate());
        views.setTxHost(transaction.getTxHost());
        viewRepository.newDashboard(views);
        Integer lastId = transactionRepository.getLastInsertId();
        viewDto.setIdView(lastId);
        return viewDto;
    }


    public void updateDashboard(Integer idUser, ViewDto dashboard) {
        LOGGER.warn(dashboard.toString());
        viewRepository.updateDashboard(idUser, dashboard.getName(), dashboard.getIdView());
    }
}
