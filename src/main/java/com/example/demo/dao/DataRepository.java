package com.example.demo.dao;

import com.example.demo.domain.Data;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataLoadedDto;
import com.example.demo.dto.DataSimpleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.*;

@Mapper
public interface DataRepository {
    // Add single row on table Data
    void addSingleData(Data data);

    //
    List<DataDto> getGeneralData();

    //
    List<DataSimpleDto> lastDataByLocation(Integer idLocation);

    //Ger general list data of a contry
    List<DataSimpleDto> listSpecificDataByIdCountry(Integer idDatatype, Integer idCountry);

    //
    List<DataDto> verifyExistenceOfData(Date date, Integer idDataType, Integer idLocation);

}
