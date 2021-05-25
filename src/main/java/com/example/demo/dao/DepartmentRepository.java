package com.example.demo.dao;

import com.example.demo.domain.Departments;
import com.example.demo.dto.DataDto;
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

    //
    List<DataDto> departmentStatistics(Integer idDepartment);

    //
    DataDto generalFirstVaccinated(Integer idDepartment);

    //
    DataDto generalSecondVaccinated(Integer idDepartment);

    // Get general list data of a department
    List<DataSimpleDto> listSpecificDataByIdDepartment(Integer idDatatype, Integer idDepartment);

    //
    List<DataDto> getDataByDepartmentId(Integer idDepartment);

}
