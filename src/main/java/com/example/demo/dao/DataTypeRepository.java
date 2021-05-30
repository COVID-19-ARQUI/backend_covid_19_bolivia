package com.example.demo.dao;

import com.example.demo.domain.Datatypes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataTypeRepository {

    // Get datatype by datatype name
    Datatypes getDataTypeByName(String nameType);
}
