package com.example.demo.dao;

import com.example.demo.domain.Dato;
import com.example.demo.dto.DatoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface DatoRepository {
    public List<DatoDto> getDatos(Integer idDepartment);

    public List<DatoDto> getDatosGenerales();

    // Add sigle row on table Dato
    public void addSingleData(Dato dato);
}
