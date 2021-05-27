package com.example.demo.service;

import com.example.demo.controller.FileController;
import com.example.demo.dto.DataLoadedDto;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FileReaderService {

    String line = "";
    private static Logger logger = LoggerFactory.getLogger(FileController.class);



    public List<DataLoadedDto> readDataFromCsv(MultipartFile file){
        List<DataLoadedDto> listDataLoaded = new ArrayList<DataLoadedDto>();
        try{
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> rows = csvReader.readAll();
            for(String[]item : rows){

                Integer data = Integer.parseInt(item[0]);
                String[]date = item[1].split("-");
                Integer day = Integer.parseInt(date[0]);
                Integer month = Integer.parseInt(date[1]);
                Integer year = Integer.parseInt(date[2]);
                Date inDate = new Date(year,month,day);
                String dataType = item[2];
                String country = item[3];
                String department = item[4];
                String municipality = item[5];
                DataLoadedDto dataLoadedDto = new DataLoadedDto(data,inDate,dataType,country,department,municipality);
                listDataLoaded.add(dataLoadedDto);

            }
        }catch (IOException e){

        }
        return listDataLoaded;
    }
}
