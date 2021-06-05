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

    // Get data by department id
    List<DataSimpleDto> getDataByDepartmentsId(Integer idDepartment);

    // Get list of all departments
    List<Departments> getDepartments();

    // Get general data by department id
    List<DataDto> departmentStatistics(Integer idDepartment);

    // Obtains general data of people vaccinated with the first dose
    DataDto generalFirstVaccinated(Integer idDepartment);

    // Obtains general data of people vaccinated with the second dose
    DataDto generalSecondVaccinated(Integer idDepartment);

    // Get general list data of a department
    List<DataSimpleDto> listSpecificDataByIdDepartment(Integer idDatatype, Integer idDepartment);

    // Get list of all data by department id
    List<DataDto> getDataByDepartmentId(Integer idDepartment);

    List<DataDto> getAccumulatedByDepartmentId(Integer idDepartment);
}
