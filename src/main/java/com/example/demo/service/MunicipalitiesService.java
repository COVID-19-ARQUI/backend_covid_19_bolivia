package com.example.demo.service;

import com.example.demo.dao.MunicipalityRepository;
import com.example.demo.domain.Municipalities;
import com.example.demo.dto.DataSimpleDto;
import com.example.demo.dto.MunicipalityDataDto;
import com.example.demo.dto.MunicipalityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MunicipalitiesService {
    private MunicipalityRepository municipalityRepository;

    @Autowired
    public MunicipalitiesService(MunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }

    public List<MunicipalityDataDto> getMunicipalityById(Integer idMunicipality) {
        return municipalityRepository.getMunicipalitiesById(idMunicipality);
    }

    public List<DataSimpleDto> getDataByIdMunicipality(Integer idDatatype, Integer idMunicipality) {
        return municipalityRepository.getDataByIdMunicipality(idDatatype, idMunicipality);
    }

    public List<MunicipalityDto> getMunicipalitiesList(Integer idDepartment) {
        List<Municipalities> municipalities = municipalityRepository.getMunicipalitiesByDepartment(idDepartment);
        List<MunicipalityDto> response = new ArrayList<>();
        municipalities.forEach(municipality -> {
            response.add(new MunicipalityDto(municipality.getIdMunicipality(), municipality.getMunicipality()));
        });
        return response;
    }
}
