package com.mag.service;

import com.mag.dao.FileDAO;
import com.mag.entity.CustomFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private FileDAO fileDAO;

    public CustomFile findCustomFileById(Long id) {
        if (fileDAO.existsById(id)) {
            return fileDAO.findCustomFileById(id);
        } else return null;
    }

    public void save(CustomFile file) {
        fileDAO.save(file);
    }
}
