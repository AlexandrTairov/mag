package com.mag.controller;

import com.mag.dao.FileDAO;
import com.mag.entity.CustomFile;
import com.mag.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;

@Controller
public class StartController {

    @Autowired
    private FileService fileService;

    @GetMapping(value = "/")
    public String startPage() {
        return "redirect:startPage.html";
    }

    @PostMapping(value = "/upload")
    public String fileUpload(@RequestParam MultipartFile file) throws IOException {
        System.out.println("Hello");

       CustomFile customFile = new CustomFile();
       customFile.setFile(DatatypeConverter.printBase64Binary(file.getBytes()));

        fileService.save(customFile);

        return "redirect:startPage.html";
    }

}
