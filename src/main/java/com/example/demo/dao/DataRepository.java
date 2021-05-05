package com.example.demo.dao;

import com.example.demo.domain.Data;
import com.example.demo.dto.DatoDto;
import com.example.demo.dto.DataCovidDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface DataRepository {
    //
    public List<DatoDto> getDatos(Integer idDepartment);

    //
    public List<DatoDto> getDatosGenerales();

    //
    public List<DatoDto> sumdato(Integer idDepartment);

    //
    public DatoDto vacuna2final(Integer idDepartment);

    //
    public DatoDto vacuna1final(Integer idDepartment);

    // Add sigle row on table Dato
    public void addSingleData(Data data);

    //
    public List<DataCovidDto> mostRecentDateOfCovidData();

    // Get general accumulate data
    public List<DataCovidDto> listDataOfDepartmentAndTypeDate(Integer tipoDatoId, Integer departmentId);
}
