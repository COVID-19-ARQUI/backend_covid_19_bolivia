package com.example.demo.dao;

import com.example.demo.dto.DashboardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DashboardRepository {
    public DashboardDto getDashboard();

}

