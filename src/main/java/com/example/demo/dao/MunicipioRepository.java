package com.example.demo.dao;

import com.example.demo.dto.DataCovidMunicipioDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MunicipioRepository {
    public List<DataCovidMunicipioDto> getDataByMunicipioId(Integer tipoDatoId, Integer municipioId);
}
