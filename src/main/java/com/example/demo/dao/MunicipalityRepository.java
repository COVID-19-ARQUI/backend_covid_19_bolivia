package com.example.demo.dao;

import com.example.demo.domain.Municipalities;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataSimpleDto;
import com.example.demo.dto.MunicipalityDataDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MunicipalityRepository {
    //
    List<DataSimpleDto> getDataByIdMunicipality(Integer idDatatype, Integer idMunicipality);

    // Get general data of municipalities by municipality id
    List<MunicipalityDataDto> getMunicipalitiesById(Integer idMunicipality);

    // Get list of all municipalities
    List<Municipalities> getMunicipalities();

    // Get list of all municipalities by department id
    List<Municipalities> getMunicipalitiesByDepartment(Integer idDepartment);

    // Get total data by municipality id
    List<DataDto> municipalityStatistics(Integer idMunicipality);

    // Get general data of municipalities by id department
    List<MunicipalityDataDto> getMunicipalitiesByIdDepartment(Integer idDepartment);

}
