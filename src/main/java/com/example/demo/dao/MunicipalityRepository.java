package com.example.demo.dao;

import com.example.demo.domain.Municipalities;
import com.example.demo.dto.DataSimpleDto;
import com.example.demo.dto.MunicipalityDataDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MunicipalityRepository {
    //
    List<DataSimpleDto> getDataByMunicipioId(Integer idDatatype, Integer idMunicipality);

    // Get general data of municipalities by department
    List<MunicipalityDataDto> getMunicipalitiesByDepartmentId(Integer idDepartment);

    // Get list of all municipalities
    List<Municipalities> getMunicipalities();
}
