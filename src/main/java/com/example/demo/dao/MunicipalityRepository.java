package com.example.demo.dao;

import com.example.demo.domain.Municipalities;
import com.example.demo.dto.DataCovidMunicipioDto;
import com.example.demo.dto.MunicipalityDataDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MunicipalityRepository {
    //
    public List<DataCovidMunicipioDto> getDataByMunicipioId(Integer tipoDatoId, Integer municipioId);

    // Get general data of municipalities by department
    public List<MunicipalityDataDto> getMunicipalitiesByDepartmentId(Integer departmentId);

    // Get list of all municipalities
    public List<Municipalities> getMunicipalities();
}
