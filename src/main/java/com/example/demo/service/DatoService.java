package com.example.demo.service;

import com.example.demo.dao.DatoRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.ZonaRepository;
import com.example.demo.domain.Dato;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DatoDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatoService {
    private DatoRepository datoRepository;
    private DepartmentRepository departmentRepository;
    private ZonaRepository zonaRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardService.class);

    @Autowired
    public DatoService(DatoRepository datoRepository, DepartmentRepository departmentRepository, ZonaRepository zonaRepository) {
        this.datoRepository = datoRepository;
        this.departmentRepository = departmentRepository;
        this.zonaRepository = zonaRepository;
    }

    public List<DatoDto> getdatos() {
        List<DatoDto> datoDtoList = datoRepository.getDatosGenerales();
        return datoDtoList;
    }

    public DataDto pushSingleData(DataDto dataDto, Transaction transaction) {
        Integer zoneId = zonaRepository.getZoneByDepartment(dataDto.getDepartment(), dataDto.getMunicipality());

        if (dataDto.getConfirmed() != null) {
            Dato contagiados = new Dato(null, dataDto.getConfirmed().toString(), dataDto.getDate(), zoneId, 1, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
            datoRepository.addSingleData(contagiados);
        }
        if (dataDto.getDeaths() != null) {
            Dato muertos = new Dato(null, dataDto.getDeaths().toString(), dataDto.getDate(), zoneId, 2, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
            datoRepository.addSingleData(muertos);
        }
        if (dataDto.getRecovered() != null) {
            Dato recuperados = new Dato(null, dataDto.getRecovered().toString(), dataDto.getDate(), zoneId, 3, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
            datoRepository.addSingleData(recuperados);
        }
        if (dataDto.getVaccinated() != null) {
            Dato vacunados = new Dato(null, dataDto.getVaccinated().toString(), dataDto.getDate(), zoneId, 4, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
            datoRepository.addSingleData(vacunados);
        }

//        Dato activos = new Dato(null, dataDto.getActives().toString(), dataDto.getDate(), zoneId, 6, transaction.getTxUserUd().toString(), transaction.getTxHost(), transaction.getTxDate());
//        if (activos.getDato() != null)
//            datoRepository.addSingleData(activos);

        LOGGER.warn(zoneId.toString());
        return dataDto;
    }

    public List<DatoDto> listDataofDepartament(Integer departmentId){
        List<DatoDto> listDataofDepartament = datoRepository.getDatos(departmentId);
        return listDataofDepartament;
    }
}
