package com.example.demo.dao;

import com.example.demo.domain.Data;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataSimpleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface DataRepository {
    //
    List<DataDto> getDatos(Integer idDepartment);

    //
    List<DataDto> getDatosGenerales();

    //
    List<DataDto> sumdato(Integer idDepartment);

    //
    DataDto vacuna2final(Integer idDepartment);

    //
    DataDto vacuna1final(Integer idDepartment);

    // Add sigle row on table Dato
    void addSingleData(Data data);

    //
    List<DataSimpleDto> mostRecentDateOfCovidData();

    // Get general accumulate data
    List<DataSimpleDto> listDataOfDepartmentAndTypeDate(Integer idDatatype, Integer idDepartment);


}
