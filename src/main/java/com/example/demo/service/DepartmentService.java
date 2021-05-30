package com.example.demo.service;

import com.example.demo.dao.DepartmentRepository;
import com.example.demo.domain.Departments;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataSimpleDto;
import com.example.demo.dto.DepartmentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Departments> getDepartments() {
        return departmentRepository.getDepartments();
    }

    public List<DepartmentDto> getDepartmentsWithMunicipalities() {
        List<Departments> departments = departmentRepository.getDepartments();
        List<DepartmentDto> result = new ArrayList<>();
        departments.forEach(department -> {
            DepartmentDto dto = new DepartmentDto();
            dto.setDepartment(department.getDepartment());
            dto.setIdDepartment(department.getIdDepartment());
            dto.setMunicipalities(departmentRepository.getMunicipalities(department.getIdDepartment()));
            result.add(dto);
        });
        return result;
    }

    public DataDto getSumDataFirstVaccinated(Integer departmentId) {
        return departmentRepository.generalFirstVaccinated(departmentId);
    }

    public DataDto getSumDataSecondVaccinated(Integer departmentId) {
        return departmentRepository.generalSecondVaccinated(departmentId);
    }

    public List<DataDto> departmentStatistics(Integer departmentId) {
        return departmentRepository.departmentStatistics(departmentId);
    }


    public List<DataSimpleDto> getDataByDepartmentsId(Integer departmentId) {
        return departmentRepository.getDataByDepartmentsId(departmentId);
    }


    public List<DataDto> listDataDepartment(Integer departmentId) {
        return departmentRepository.getDataByDepartmentId(departmentId);
    }
}
