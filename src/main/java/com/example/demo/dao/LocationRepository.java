package com.example.demo.dao;

import com.example.demo.domain.Countries;
import com.example.demo.domain.Departments;
import com.example.demo.domain.Municipalities;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LocationRepository {
    // Get Zone id by department and municipality
    public Integer getZoneByDepartment(String department, String municipalities);

    // Get list of all countries
    public List<Countries> getCountries();

}
