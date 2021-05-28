package com.example.demo.dao;

import com.example.demo.domain.Views;
import com.example.demo.dto.ViewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ViewRepository {

    // Add new dashboard
    void newDashboard(Views views);

    // Get dashboards by user id
    List<ViewDto> getDashboardsByUserId(Integer idUser);

    //
    void updateDashboard(Integer idUser, String name, Integer idDashboard);

}

