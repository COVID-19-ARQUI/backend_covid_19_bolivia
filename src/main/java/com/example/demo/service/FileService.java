package com.example.demo.service;

import com.example.demo.dao.DataRepository;
import com.example.demo.dao.DataTypeRepository;
import com.example.demo.dao.DepartmentRepository;
import com.example.demo.dao.LocationRepository;
import com.example.demo.domain.Data;
import com.example.demo.domain.Datatypes;
import com.example.demo.domain.Locations;
import com.example.demo.domain.Transaction;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.DataLoadedDto;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileService {

    private String  upload_folder= ".//src//main//resources//files//";
    private static Logger logger = LoggerFactory.getLogger(FileService.class);


    private DataRepository dataRepository;
    private LocationRepository locationRepository;
    private DataTypeRepository dataTypeRepository;

    @Autowired
    public FileService(DataRepository dataRepository, LocationRepository locationRepository, DataTypeRepository dataTypeRepository) {
        this.dataRepository = dataRepository;
        this.locationRepository = locationRepository;
        this.dataTypeRepository = dataTypeRepository;
    }

    public void saveFile(MultipartFile file)throws IOException {
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            Path path = Paths.get(upload_folder+ file.getOriginalFilename());
            Files.write(path,bytes);

        }

    }

    public void addDatafromCsvFile(MultipartFile file, Transaction transaction){
        logger.info("ACCESO A METODO");
        List<DataLoadedDto>dataLoadedDtos = new ArrayList<>();
        try{
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> rows = csvReader.readAll();
            for(String[]item : rows){

                Integer data = Integer.parseInt(item[0]);
                String inDate = item[1];
                String dataType = item[2];
                String country = item[3];
                String department = item[4];
                String municipality = item[5];
                DataLoadedDto dataLoadedDto = new DataLoadedDto(data,inDate,dataType,country,department,municipality);
                dataLoadedDtos.add(dataLoadedDto);
            }
            for(DataLoadedDto data: dataLoadedDtos){
                Locations locations = locationRepository.getLocationsByCountryDepartmentMuniciplaity(
                        data.getCountry(),data.getDepartment(),data.getMunicipality());

                Datatypes datatypes = dataTypeRepository.getDataTypeByName(data.getDataType());

                List<DataDto> listaData= dataRepository.verifyExistenceOfData(data.getInDate(),datatypes.getIdDatatype(),locations.getIdLocation());
                logger.info("EL TAMAÑO ES: "+listaData.size());
                if(listaData.isEmpty()){

                    String date[] = data.getInDate().split("-");
                    int year = Integer.parseInt(date[0]);
                    int month = Integer.parseInt(date[1]);
                    int day = Integer.parseInt(date[2]);

                    Data newDate = new Data(null, data.getData(), new Date(year,month,day), locations.getIdLocation(),
                            datatypes.getIdDatatype(), 1, transaction.getTxUserId().toString(), transaction.getTxHost(), transaction.getTxDate());
                    dataRepository.addSingleData(newDate);
                }else{

                }

            }

        }catch (IOException e){
            logger.info("HA OCURRIDO UN ERROR");
        }
    }
}
