package com.example.demo.dao;

import com.example.demo.domain.Dato;
import com.example.demo.dto.DataCovidDepartmentDto;
import com.example.demo.dto.DatoDto;
import com.example.demo.dto.DateCovidDto;
import com.example.demo.dto.GeneralDataDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface DatoRepository {
    public List<DatoDto> getDatos(Integer idDepartment);

    public List<DatoDto> getDatosGenerales();

    public List<DatoDto> sumdato(Integer idDepartment);

    // Add sigle row on table Dato
    public void addSingleData(Dato dato);

    public List<DateCovidDto> mostRecentDateOfCovidData();

    // Get general accumulate data
    public GeneralDataDto getGeneralAccumulateData();
    public List<DataCovidDepartmentDto>listDataOfDepartmentAndTypeDate(Integer tipoDatoId, Integer departmentId);
}
