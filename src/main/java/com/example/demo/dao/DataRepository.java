package com.example.demo.dao;

import com.example.demo.domain.Data;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataSimpleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface DataRepository {
    // Add sigle row on table Dato
    void addSingleData(Data data);

    //
    List<DataDto> getData(Integer idDepartment);

    //
    List<DataDto> getGeneralData();

    //
    List<DataDto> departmentStatistics(Integer idDepartment);


    //
    DataDto generalFirstVaccinated(Integer idDepartment);

    //
    DataDto generalSecondVaccinated(Integer idDepartment);

    //
    List<DataSimpleDto> lastDataByLocation(Integer idLocation);

    // Get general list data of a department
    List<DataSimpleDto> listSpecificDataByIdDepartment(Integer idDatatype, Integer idDepartment);
    //Ger general list data of a contry
    List<DataSimpleDto> listSpecificDataByIdCountry(Integer idDatatype, Integer idCountry);


}
