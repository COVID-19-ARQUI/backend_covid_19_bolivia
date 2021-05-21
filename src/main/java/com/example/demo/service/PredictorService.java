package com.example.demo.service;

import com.example.demo.dao.DataRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataSimpleDto;
import com.example.demo.util.Matriz;
import com.example.demo.util.Modelado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public List<DataSimpleDto> mostrarMatriz(Integer dataType,List<DataSimpleDto> data, Integer predictAmount) throws ParseException {
        Modelado modelado = new Modelado();
        Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(data.get(data.size()-1).getInDate());
        double[][] as= new double[data.size()][1];
        List<DataSimpleDto> response= new ArrayList<>();
        data.forEach(dataSimpleDto -> {
            as[data.indexOf(dataSimpleDto)][1]= dataSimpleDto.getData();
        });
        double[][] result=modelado.pronosticar(as,3,predictAmount);
        for (int i=0;i<=result.length;i++){
            DataSimpleDto dataSimpleDto=new DataSimpleDto();
            dataSimpleDto.setData((int) result[i][0]);
            dataSimpleDto.setInDate(sumarRestarDiasFecha(date1,i+1).toString());
            dataSimpleDto.setDatatype(dataType.toString());

            response.add(dataSimpleDto);
        }
        data.addAll(response);
        return data;
    }
    public Date sumarRestarDiasFecha(Date fecha, int dias){

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fecha); // Configuramos la fecha que se recibe

        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0

        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

    }
}
