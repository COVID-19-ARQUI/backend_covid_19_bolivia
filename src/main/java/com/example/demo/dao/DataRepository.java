package com.example.demo.dao;

import com.example.demo.domain.Data;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataSimpleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface DataRepository {
    //
    public List<DataDto> getDatos(Integer idDepartment);

    //
    public List<DataDto> getDatosGenerales();

    //
    public List<DataDto> sumdato(Integer idDepartment);

    //
    public DataDto vacuna2final(Integer idDepartment);

    //
    public DataDto vacuna1final(Integer idDepartment);

    // Add sigle row on table Dato
    public void addSingleData(Data data);

    //
    public List<DataSimpleDto> mostRecentDateOfCovidData();

    // Get general accumulate data
    public List<DataSimpleDto> listDataOfDepartmentAndTypeDate(Integer idDatatype, Integer idDepartment);
}
