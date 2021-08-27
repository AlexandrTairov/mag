package com.mag.dao;

import com.mag.entity.CustomFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDAO extends JpaRepository<CustomFile, Long> {

    CustomFile findCustomFileById(Long id);
}
