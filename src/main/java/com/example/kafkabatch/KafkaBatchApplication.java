package com.example.kafkabatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KafkaBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaBatchApplication.class, args);
    }

}

