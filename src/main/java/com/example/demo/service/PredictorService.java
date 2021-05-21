package com.example.demo.service;

import com.example.demo.dao.DataRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dto.DataSimpleDto;
import com.example.demo.util.Modelado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Service
public class PredictorService {
    private DepartmentRepository departmentRepository;
    private DataRepository dataRepository;

    @Autowired
    public PredictorService(DepartmentRepository departmentRepository, DataRepository dataRepository) {
        this.departmentRepository = departmentRepository;
        this.dataRepository = dataRepository;
    }

    public List<DataSimpleDto> datapredicted(Integer iddepartment, Integer predictAmount) throws ParseException {
        List<DataSimpleDto> contagiados=dataRepository.listSpecificDataByIdDepartment(1,iddepartment);
        List<DataSimpleDto> muertos=dataRepository.listSpecificDataByIdDepartment(2,iddepartment);
        List<DataSimpleDto> recuperados=dataRepository.listSpecificDataByIdDepartment(3,iddepartment);

        List<DataSimpleDto> response= new ArrayList<>();
        response.addAll(mostrarMatriz(1,contagiados,predictAmount));
        response.addAll(mostrarMatriz(2,muertos,predictAmount));
        response.addAll(mostrarMatriz(3,recuperados,predictAmount));
        return response;
    }
    public List<DataSimpleDto> datapredictedcountry(Integer idcountry, Integer predictAmount) throws ParseException {
        List<DataSimpleDto> contagiados=dataRepository.listSpecificDataByIdCountry(1,idcountry);
        List<DataSimpleDto> muertos=dataRepository.listSpecificDataByIdCountry(2,idcountry);
        List<DataSimpleDto> recuperados=dataRepository.listSpecificDataByIdCountry(3,idcountry);

        List<DataSimpleDto> response= new ArrayList<>();
        response.addAll(mostrarMatriz(1,contagiados,predictAmount));
        response.addAll(mostrarMatriz(2,muertos,predictAmount));
        response.addAll(mostrarMatriz(3,recuperados,predictAmount));
        return response;
    }
    public List<DataSimpleDto> mostrarMatriz(Integer dataType,List<DataSimpleDto> data, Integer predictAmount) throws ParseException {
        Modelado modelado = new Modelado();
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(data.get(data.size()-1).getInDate());
        double[][] as= new double[data.size()][1];
        List<DataSimpleDto> response= new ArrayList<>();

        data.forEach(dataSimpleDto -> {
            as[data.indexOf(dataSimpleDto)][0]= dataSimpleDto.getData();
        });
        double[][] result=modelado.pronosticar(as,3,predictAmount);

        for (int i=0;i<result.length;i++){
            DataSimpleDto dataSimpleDto=new DataSimpleDto();
            dataSimpleDto.setData((int) result[i][0]);
            dataSimpleDto.setInDate(sumarRestarDiasFecha(date1,i+1));
            dataSimpleDto.setDatatype(data.get(1).getDatatype());
            response.add(dataSimpleDto);
        }

        data.addAll(response);
        return data;
    }
    public String sumarRestarDiasFecha (Date fecha, int dias) throws ParseException {

        String dateFormat="yyyy-MM-dd";
        DateTimeFormatter formatter2=DateTimeFormatter.ofPattern(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());

    }
}
