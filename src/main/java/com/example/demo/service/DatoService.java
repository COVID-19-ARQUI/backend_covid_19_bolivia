package com.example.demo.service;

import com.example.demo.dao.DatoRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.MunicipioRepository;
import com.example.demo.dao.ZonaRepository;
import com.example.demo.domain.Data;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DatoService {
    private DatoRepository datoRepository;
    private DepartmentRepository departmentRepository;
    private ZonaRepository zonaRepository;
    private MunicipioRepository municipioRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardService.class);

    @Autowired
    public DatoService(DatoRepository datoRepository, DepartmentRepository departmentRepository, ZonaRepository zonaRepository, MunicipioRepository municipioRepository) {
        this.datoRepository = datoRepository;
        this.departmentRepository = departmentRepository;
        this.zonaRepository = zonaRepository;
        this.municipioRepository = municipioRepository;
    }

    public List<DatoDto> getdatos() {
        List<DatoDto> datoDtoList = datoRepository.getDatosGenerales();
        return datoDtoList;
    }
    public DatoDto getdatosvac1(Integer departmentId) {
        return datoRepository.vacuna1final(departmentId);
    }
    public DatoDto getdatosvac2(Integer departmentId) {
        return datoRepository.vacuna2final(departmentId);
    }

    public DataDto pushSingleData(DataDto dataDto, Transaction transaction) {
        Integer zoneId = zonaRepository.getZoneByDepartment(dataDto.getDepartment(), dataDto.getMunicipality());
        LOGGER.warn(zoneId != null ? zoneId.toString() : null);
        if (dataDto.getConfirmed() != null) {
            Data contagiados = new Data(null, dataDto.getConfirmed().toString(), dataDto.getDate(), zoneId, 1, 1, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
            datoRepository.addSingleData(contagiados);
        }
        if (dataDto.getDeaths() != null) {
            Data muertos = new Data(null, dataDto.getDeaths().toString(), dataDto.getDate(), zoneId, 2, 1, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
            datoRepository.addSingleData(muertos);
        }
        if (dataDto.getRecovered() != null) {
            Data recuperados = new Data(null, dataDto.getRecovered().toString(), dataDto.getDate(), zoneId, 3, 1, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
            datoRepository.addSingleData(recuperados);
        }
        if (dataDto.getVaccinated() != null) {
            Data vacunados = new Data(null, dataDto.getVaccinated().toString(), dataDto.getDate(), zoneId, 4, 1, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
            datoRepository.addSingleData(vacunados);
        }

//        Dato activos = new Dato(null, dataDto.getActives().toString(), dataDto.getDate(), zoneId, 6, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
//        if (activos.getDato() != null)
//            datoRepository.addSingleData(activos);

        LOGGER.warn(zoneId.toString());
        return dataDto;
    }

    public List<DatoDto> listDataofDepartament(Integer departmentId) {
        List<DatoDto> listDataofDepartament = datoRepository.getDatos(departmentId);
        return listDataofDepartament;
    }

    public List<DatoDto> sumdatos(Integer departmentId) {
        List<DatoDto> listDataofDepartament = datoRepository.sumdato(departmentId);
        return listDataofDepartament;
    }

    public List<DepartmentDto> getDepartments() {
        List<DepartmentDto> departments = departmentRepository.getDepartments();
        List<DepartmentDto> result = new ArrayList<>();
        departments.forEach(departmentDto -> {
            DepartmentDto dto = new DepartmentDto();
            dto.setDepartment(departmentDto.getDepartment());
            dto.setIdDepartment(departmentDto.getIdDepartment());
            dto.setMunicipalities(departmentRepository.getMunicipalities(departmentDto.getIdDepartment()));
//            LOGGER.error(dto.toString());
            result.add(dto);
        });
        return result;
    }

    public List<DepartmentDataDto> getDataByDepartmentsId(Integer departmentId) {
        List<DepartmentDataDto> listDepartmentsDataById = departmentRepository.getDataByDepartmentsId(departmentId);
        return listDepartmentsDataById;
    }

    public List<DateCovidDto> mostRecentDateOfCovidData() {
        List<DateCovidDto> mostRecentDateOfCovidData = datoRepository.mostRecentDateOfCovidData();
        return mostRecentDateOfCovidData;
    }

    public List<DataCovidDepartmentDto>listDataOfDepartmentAndTypeDate(Integer tipoDatoId, Integer departmentId){
        List<DataCovidDepartmentDto>list = datoRepository.listDataOfDepartmentAndTypeDate(tipoDatoId, departmentId);
        return list;
    }
    public List<DataCovidMunicipioDto>getDataByMunicipioId(Integer tipoDatoId, Integer municipioId){
        List<DataCovidMunicipioDto>list = municipioRepository.getDataByMunicipioId(tipoDatoId, municipioId);
        return list;
    }
}
