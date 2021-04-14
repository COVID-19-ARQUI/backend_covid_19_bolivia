package com.example.demo.dto;

import java.util.List;

public class DashboardDto {

    private Integer idDepartment;
    private String department;
    private List<DatoDto> datoDto;

    public DashboardDto() {
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<DatoDto> getDatoDto() {
        return datoDto;
    }

    public void setDatoDto(List<DatoDto> datoDto) {
        this.datoDto = datoDto;
    }
}
