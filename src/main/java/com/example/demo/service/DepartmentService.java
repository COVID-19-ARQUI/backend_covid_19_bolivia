package com.example.demo.service;

import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.MunicipalityRepository;
import com.example.demo.domain.Departments;
import com.example.demo.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;

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
}
