package com.example.demo.dao;

import com.example.demo.domain.Views;
import com.example.demo.dto.ViewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ViewRepository {

    // Add new view
    void newDashboard(Views views);

    // Get dashboards by user id
    List<ViewDto> getDashboardsByUserId(Integer idUser);

    // Update view name with user id and dashboard id
    void updateDashboard(Integer idUser, String name, Integer idDashboard);

}

