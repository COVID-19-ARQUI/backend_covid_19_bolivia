package com.example.demo.dao;

import com.example.demo.domain.Departments;
import com.example.demo.dto.DataSimpleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface DepartmentRepository {

    // Get municipalities by department ID
    List<String> getMunicipalities(Integer idDepartment);

    //
    List<DataSimpleDto> getDataByDepartmentsId(Integer departmentId);

    // Get list of all departments
    public List<Departments> getDepartments();

}
