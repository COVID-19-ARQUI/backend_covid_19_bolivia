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

    public List<DatoDto> getdatos() {
        List<DatoDto> datoDtoList = dataRepository.getDatosGenerales();
        return datoDtoList;
    }

    public DatoDto getdatosvac1(Integer departmentId) {
        return dataRepository.vacuna1final(departmentId);
    }

    public DatoDto getdatosvac2(Integer departmentId) {
        return dataRepository.vacuna2final(departmentId);
    }

    public DataDto pushSingleData(DataDto dataDto, Transaction transaction) {
        Integer zoneId = locationRepository.getZoneByDepartment(dataDto.getDepartment(), dataDto.getMunicipality());
        LOGGER.warn(zoneId != null ? zoneId.toString() : null);
        if (dataDto.getConfirmed() != null) {
            Data contagiados = new Data(null, dataDto.getConfirmed().toString(), dataDto.getDate(), zoneId, 1, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(contagiados);
        }
        if (dataDto.getDeaths() != null) {
            Data muertos = new Data(null, dataDto.getDeaths().toString(), dataDto.getDate(), zoneId, 2, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(muertos);
        }
        if (dataDto.getRecovered() != null) {
            Data recuperados = new Data(null, dataDto.getRecovered().toString(), dataDto.getDate(), zoneId, 3, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(recuperados);
        }
        if (dataDto.getVaccinated() != null) {
            Data vacunados = new Data(null, dataDto.getVaccinated().toString(), dataDto.getDate(), zoneId, 4, 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
            dataRepository.addSingleData(vacunados);
        }

//        Dato activos = new Dato(null, dataDto.getActives().toString(), dataDto.getDate(), zoneId, 6, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
//        if (activos.getDato() != null)
//            datoRepository.addSingleData(activos);

        LOGGER.warn(zoneId.toString());
        return dataDto;
    }

    public List<DatoDto> listDataofDepartament(Integer departmentId) {
        List<DatoDto> listDataofDepartament = dataRepository.getDatos(departmentId);
        return listDataofDepartament;
    }

    public List<DatoDto> sumdatos(Integer departmentId) {
        List<DatoDto> listDataofDepartament = dataRepository.sumdato(departmentId);
        return listDataofDepartament;
    }

    public List<DepartmentDataDto> getDataByDepartmentsId(Integer departmentId) {
        List<DepartmentDataDto> listDepartmentsDataById = departmentRepository.getDataByDepartmentsId(departmentId);
        return listDepartmentsDataById;
    }

    public List<DataCovidDto> mostRecentDateOfCovidData() {
        List<DataCovidDto> mostRecentDateOfCovidData = dataRepository.mostRecentDateOfCovidData();
        return mostRecentDateOfCovidData;
    }

    public List<DataCovidDto> listDataOfDepartmentAndTypeDate(Integer tipoDatoId, Integer departmentId) {
        List<DataCovidDto> list = dataRepository.listDataOfDepartmentAndTypeDate(tipoDatoId, departmentId);
        return list;
    }

    public List<DataCovidDto> getDataByMunicipioId(Integer tipoDatoId, Integer municipioId) {
        List<DataCovidDto> list = municipalityRepository.getDataByMunicipioId(tipoDatoId, municipioId);
        return list;
    }
}
