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

    public List<DataDto> getdatos() {
        List<DataDto> dataDtoList = dataRepository.getDatosGenerales();
        return dataDtoList;
    }

    public DataDto getdatosvac1(Integer departmentId) {
        return dataRepository.vacuna1final(departmentId);
    }

    public DataDto getdatosvac2(Integer departmentId) {
        return dataRepository.vacuna2final(departmentId);
    }

    public DailyDataDto pushSingleData(DailyDataDto dailyDataDto, Transaction transaction) {
        Integer zoneId = locationRepository.getZoneByDepartment(dailyDataDto.getDepartment(), dailyDataDto.getMunicipality());
        LOGGER.warn(zoneId != null ? zoneId.toString() : null);
        if (dailyDataDto.getConfirmed() != null) {
            Data contagiados = new Data(null, dailyDataDto.getConfirmed().toString(), dailyDataDto.getDate(), zoneId, 1, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(contagiados);
        }
        if (dailyDataDto.getDeaths() != null) {
            Data muertos = new Data(null, dailyDataDto.getDeaths().toString(), dailyDataDto.getDate(), zoneId, 2, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(muertos);
        }
        if (dailyDataDto.getRecovered() != null) {
            Data recuperados = new Data(null, dailyDataDto.getRecovered().toString(), dailyDataDto.getDate(), zoneId, 3, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(recuperados);
        }
        if (dailyDataDto.getVaccinated() != null) {
            Data vacunados = new Data(null, dailyDataDto.getVaccinated().toString(), dailyDataDto.getDate(), zoneId, 4, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(vacunados);
        }

//        Dato activos = new Dato(null, dataDto.getActives().toString(), dataDto.getDate(), zoneId, 6, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
//        if (activos.getDato() != null)
//            datoRepository.addSingleData(activos);

        LOGGER.warn(zoneId.toString());
        return dailyDataDto;
    }

    public List<DataDto> listDataofDepartament(Integer departmentId) {
        List<DataDto> dataDtoList = dataRepository.getDatos(departmentId);
        LOGGER.warn(dataDtoList.toString());
        return dataDtoList;
    }

    public List<DataDto> sumdatos(Integer departmentId) {
        List<DataDto> listDataofDepartament = dataRepository.sumdato(departmentId);
        return listDataofDepartament;
    }

    public List<DataSimpleDto> getDataByDepartmentsId(Integer departmentId) {
        List<DataSimpleDto> listDepartmentsDataById = departmentRepository.getDataByDepartmentsId(departmentId);
        return listDepartmentsDataById;
    }

    public List<DataSimpleDto> mostRecentDateOfCovidData() {
        return dataRepository.mostRecentDateOfCovidData();
    }

    public List<DataSimpleDto> listDataOfDepartmentAndTypeDate(Integer tipoDatoId, Integer departmentId) {
        return dataRepository.listDataOfDepartmentAndTypeDate(tipoDatoId, departmentId);
    }

    public List<DataSimpleDto> getDataByMunicipioId(Integer tipoDatoId, Integer municipioId) {
        return municipalityRepository.getDataByMunicipioId(tipoDatoId, municipioId);
    }
}
