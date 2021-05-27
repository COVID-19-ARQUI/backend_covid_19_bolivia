package com.example.demo.controller;

import com.example.demo.domain.Transaction;
import com.example.demo.service.FileService;
import com.example.demo.service.TransactionService;
import com.example.demo.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
@RestController
@RequestMapping(value = "/file")
@CrossOrigin(origins = "http://localhost:4200")
public class FileController {

    private final FileService fileService;
    private final TransactionService transactionService;

    @Autowired
    public FileController(FileService fileService, TransactionService transactionService){
        this.fileService = fileService;
        this.transactionService = transactionService;
    }

    private static Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }
        InputStream inputStream = file.getInputStream();
        String originalName = file.getOriginalFilename();
        String name = file.getName();
        String contentType = file.getContentType();

        long size = file.getSize();
        logger.info("inputStream: " + inputStream);
        logger.info("originalName: " + originalName);
        logger.info("name: " + name);
        logger.info("contentType: " + contentType);
        logger.info("size: " + size);
        //fileService.saveFile(file);
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionService.createTransaction(transaction);
        fileService.addDatafromCsvFile(file,transaction);
        // Do processing with uploaded file data in Service layer
        return new ResponseEntity<String>(originalName, HttpStatus.OK);
    }




}
