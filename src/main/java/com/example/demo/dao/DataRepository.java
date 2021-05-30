package com.example.demo.dao;

import com.example.demo.domain.Data;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataSimpleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface DataRepository {

    // Add single row on table Data
    void addSingleData(Data data);

    // Get general data
    List<DataDto> getGeneralData();

    // Get last general data by id location
    List<DataSimpleDto> lastDataByLocation(Integer idLocation);

    // Get general list data of a contry
    List<DataSimpleDto> listSpecificDataByIdCountry(Integer idDatatype, Integer idCountry);

    // Verifies if exist a data in the same date
    List<DataDto> verifyExistenceOfData(Date date, Integer idDataType, Integer idLocation);

}
