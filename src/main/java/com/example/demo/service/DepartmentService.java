package com.example.demo.service;

import com.example.demo.dao.DepartmentRepository;
import com.example.demo.domain.Departments;
import com.example.demo.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Departments> getDepartments() {
        return departmentRepository.getDepartments();
    }

    public List<DepartmentDto> getDepartmentsWithMunicipalities() {
        List<Departments> departments = departmentRepository.getDepartments();
        List<DepartmentDto> result = new ArrayList<>();
        departments.forEach(department -> {
            DepartmentDto dto = new DepartmentDto();
            dto.setDepartment(department.getDepartment());
            dto.setIdDepartment(department.getIdDepartment());
            dto.setMunicipalities(departmentRepository.getMunicipalities(department.getIdDepartment()));
            result.add(dto);
        });
        return result;
    }

    public DataDto getSumDataFirstVaccinated(Integer departmentId) {
        return departmentRepository.generalFirstVaccinated(departmentId);
    }

    public DataDto getSumDataSecondVaccinated(Integer departmentId) {
        return departmentRepository.generalSecondVaccinated(departmentId);
    }

    public List<DataDto> departmentStatistics(Integer departmentId) {
        return departmentRepository.departmentStatistics(departmentId);
    }


    public List<DataSimpleDto> getDataByDepartmentsId(Integer departmentId) {
        return departmentRepository.getDataByDepartmentsId(departmentId);
    }


    public List<DataDto> listDataDepartment(Integer departmentId) {
        return departmentRepository.getDataByDepartmentId(departmentId);
    }


    public List<DashboardChartsDto> getAccumulatedDataByDepartment() {
        List<Departments> departments = departmentRepository.getDepartments();
        List<DashboardChartsDto> result = new ArrayList<>();
        departments.forEach(department -> {
            DashboardChartsDto data = new DashboardChartsDto();
            List<DataSimpleDto> dataDto = new ArrayList<>();
            final Integer[] sum = {0};

            List<DataSimpleDto> data1 = departmentRepository.listSpecificDataByIdDepartment(1, department.getIdDepartment());
            dataDto.add(new DataSimpleDto(sum[0], data1.get(0).getInDate(), data1.get(0).getDatatype()));
            data1.forEach(dataSimpleDto -> {
                sum[0] = sum[0] + dataSimpleDto.getData();
                dataDto.add(new DataSimpleDto(sum[0], dataSimpleDto.getInDate(), dataSimpleDto.getDatatype()));
            });

            sum[0] = 0;
            List<DataSimpleDto> data2 = departmentRepository.listSpecificDataByIdDepartment(2, department.getIdDepartment());
            dataDto.add(new DataSimpleDto(sum[0], data2.get(0).getInDate(), data2.get(0).getDatatype()));
            data2.forEach(dataSimpleDto -> {
                sum[0] = sum[0] + dataSimpleDto.getData();
                dataDto.add(new DataSimpleDto(sum[0], dataSimpleDto.getInDate(), dataSimpleDto.getDatatype()));
            });

            sum[0] = 0;
            List<DataSimpleDto> data3 = departmentRepository.listSpecificDataByIdDepartment(3, department.getIdDepartment());
            dataDto.add(new DataSimpleDto(sum[0], data3.get(0).getInDate(), data3.get(0).getDatatype()));
            data3.forEach(dataSimpleDto -> {
                sum[0] = sum[0] + dataSimpleDto.getData();
                dataDto.add(new DataSimpleDto(sum[0], dataSimpleDto.getInDate(), dataSimpleDto.getDatatype()));
            });

            sum[0] = 0;
            List<DataSimpleDto> data4 = departmentRepository.listSpecificDataByIdDepartment(4, department.getIdDepartment());
            dataDto.add(new DataSimpleDto(sum[0], data4.get(0).getInDate(), data4.get(0).getDatatype()));
            data4.forEach(dataSimpleDto -> {
                sum[0] = sum[0] + dataSimpleDto.getData();
                dataDto.add(new DataSimpleDto(sum[0], dataSimpleDto.getInDate(), dataSimpleDto.getDatatype()));
            });

            sum[0] = 0;
            List<DataSimpleDto> data5 = departmentRepository.listSpecificDataByIdDepartment(5, department.getIdDepartment());
            dataDto.add(new DataSimpleDto(sum[0], data5.get(0).getInDate(), data5.get(0).getDatatype()));
            data5.forEach(dataSimpleDto -> {
                sum[0] = sum[0] + dataSimpleDto.getData();
                dataDto.add(new DataSimpleDto(sum[0], dataSimpleDto.getInDate(), dataSimpleDto.getDatatype()));
            });

            data.setDepartment(department.getDepartment());
            data.setIdDepartment(department.getIdDepartment());
            data.setDataDto(dataDto);
            result.add(data);
        });
        return result;
    }

}
