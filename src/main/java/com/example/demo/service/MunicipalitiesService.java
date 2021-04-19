package com.example.demo.service;

import com.example.demo.dao.MunicipioRepository;
import com.example.demo.dto.DashboardDto;
import com.example.demo.dto.MunicipalityDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class MunicipalitiesService {
    private MunicipioRepository municipioRepository;

    @Autowired
    public MunicipalitiesService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    public List<MunicipalityDataDto> getMunicipalityByDepartment(Integer departmentId) {
        return municipioRepository.getMunicipalitiesByDepartmentId(departmentId);
    }
}
