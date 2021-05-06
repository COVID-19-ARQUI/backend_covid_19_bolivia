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
    List<DataSimpleDto> getDataByDepartmentsId(Integer idDepartment);

    // Get list of all departments
    List<Departments> getDepartments();

}
