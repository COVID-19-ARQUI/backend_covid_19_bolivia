package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ZonaRepository {
    // Get Zone id by department and municipality
    public Integer getZoneByDepartment(String department, String municipalities);
}
