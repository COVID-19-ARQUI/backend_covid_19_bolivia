package com.example.demo.service;

import com.example.demo.dao.DataRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.MunicipalityRepository;
import com.example.demo.dao.LocationRepository;
import com.example.demo.domain.Data;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {
    private DataRepository dataRepository;
    private DepartmentRepository departmentRepository;
    private LocationRepository locationRepository;
    private MunicipalityRepository municipalityRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardService.class);

    @Autowired
    public DataService(DataRepository dataRepository, DepartmentRepository departmentRepository, LocationRepository locationRepository, MunicipalityRepository municipalityRepository) {
        this.dataRepository = dataRepository;
        this.departmentRepository = departmentRepository;
        this.locationRepository = locationRepository;
        this.municipalityRepository = municipalityRepository;
    }

    public DataDto getSumDataFirstVaccinated(Integer departmentId) {
        return dataRepository.generalFirstVaccinated(departmentId);
    }

    public DataDto getSumDataSecondVaccinated(Integer departmentId) {
        return dataRepository.generalSecondVaccinated(departmentId);
    }

    public DailyDataDto pushSingleData(DailyDataDto dailyDataDto, Transaction transaction) {
        Integer idLocation = locationRepository.getLocationByDepartment(dailyDataDto.getDepartment(), dailyDataDto.getMunicipality());
        LOGGER.warn(idLocation != null ? idLocation.toString() : null);
        if (dailyDataDto.getConfirmed() != null) {
            Data contagiados = new Data(null, dailyDataDto.getConfirmed().toString(), dailyDataDto.getDate(), idLocation, 1, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(contagiados);
        }
        if (dailyDataDto.getDeaths() != null) {
            Data muertos = new Data(null, dailyDataDto.getDeaths().toString(), dailyDataDto.getDate(), idLocation, 2, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(muertos);
        }
        if (dailyDataDto.getRecovered() != null) {
            Data recuperados = new Data(null, dailyDataDto.getRecovered().toString(), dailyDataDto.getDate(), idLocation, 3, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(recuperados);
        }
        if (dailyDataDto.getVaccinated() != null) {
            Data vacunados = new Data(null, dailyDataDto.getVaccinated().toString(), dailyDataDto.getDate(), idLocation, 4, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(vacunados);
        }

//        Dato activos = new Dato(null, dataDto.getActives().toString(), dataDto.getDate(), idLocation, 6, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
//        if (activos.getDato() != null)
//            datoRepository.addSingleData(activos);

        assert idLocation != null;
        LOGGER.warn(idLocation.toString());
        return dailyDataDto;
    }

    public List<DataDto> listDataofDepartament(Integer departmentId) {
        List<DataDto> dataDtoList = dataRepository.getData(departmentId);
        LOGGER.warn(dataDtoList.toString());
        return dataDtoList;
    }

    public List<DataDto> departmentStatistics(Integer departmentId) {
        return dataRepository.departmentStatistics(departmentId);
    }

    public List<DataSimpleDto> getDataByDepartmentsId(Integer departmentId) {
        return departmentRepository.getDataByDepartmentsId(departmentId);
    }

    public List<DataSimpleDto> lastDataByLocation(Integer idLocation) {
        return dataRepository.lastDataByLocation(idLocation);
    }

    public List<DataSimpleDto> listSpecificDataByIdDepartment(Integer idDatatype, Integer idDepartment) {
        return dataRepository.listSpecificDataByIdDepartment(idDatatype, idDepartment);
    }

    public List<DataDto> getDataByCountryId(String idCountry) {
        return locationRepository.getGeneralDataByCountry(idCountry);
    }
}
