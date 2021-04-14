package com.example.demo.dao;

import com.example.demo.dto.DatoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface DatoRepository {
    public List<DatoDto> getDatos(Integer idDepartment);
}
