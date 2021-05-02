package com.example.demo.dao;

import com.example.demo.dto.DepartmentDataDto;
import com.example.demo.dto.DepartmentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface DepartmentRepository {
    //
    public List<DepartmentDto> getDepartments();

    // Get municipalities by department ID
    List<String> getMunicipalities(Integer idDepartment);

    //
    List<DepartmentDataDto> getDataByDepartmentsId(Integer departmentId);
}
