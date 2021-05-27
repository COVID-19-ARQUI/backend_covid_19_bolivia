package com.example.demo.dao;

import com.example.demo.domain.Countries;
import com.example.demo.domain.Locations;
import com.example.demo.dto.DataDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Mapper
public interface LocationRepository {
    // Get Location id by department and municipality
    Integer getLocationByDepartment(String department, String municipalities);

    // Get list of all countries
    List<Countries> getCountries();

    // Get general general data by country id
    List<DataDto> getGeneralDataByCountry(String idCountry);
    //Get list of general data by country id

    List<DataDto> getDataByCountry(String idCountry);

    Locations getLocationsByCountryDepartmentMuniciplaity(String country, String department, String municipality);

}
