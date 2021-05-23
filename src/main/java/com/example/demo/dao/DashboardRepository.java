package com.example.demo.dao;

import com.example.demo.domain.Dashboard;
import com.example.demo.dto.DashboardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DashboardRepository {

    // add new dashboard
    void newDashboard(Dashboard dashboard);

    // Get dashboards by user id
    List<DashboardDto> getDashboardsByUserId(Integer idUser);


    void updateDashboard(Integer idUser, String name, Integer idDashboard);
}

