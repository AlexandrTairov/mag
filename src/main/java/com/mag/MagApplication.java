package com.mag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = "com.mag.dao")
public class MagApplication {

    public static void main(String[] args) {
        SpringApplication.run(MagApplication.class, args);
    }

}
