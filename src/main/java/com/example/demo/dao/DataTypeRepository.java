package com.example.demo.dao;

import com.example.demo.domain.Datatypes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataTypeRepository {
    Datatypes getDataTypeByName(String nameType);
}
