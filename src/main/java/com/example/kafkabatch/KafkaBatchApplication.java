package com.example.kafkabatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class KafkaBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaBatchApplication.class, args);
    }


    @Bean
    public Consumer<String> log() {
        return str -> System.out.println("test:" + str);
    }
}

