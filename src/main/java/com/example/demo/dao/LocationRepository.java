package com.example.demo.dao;

import com.example.demo.domain.Countries;
import com.example.demo.dto.DataDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationRepository {
    // Get Zone id by department and municipality
    Integer getZoneByDepartment(String department, String municipalities);

    // Get list of all countries
    List<Countries> getCountries();

    // Get general general data by country id
    List<DataDto> getGeneralDataByCountry(String idCountry);
}
