package com.example.travelbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
//@ComponentScan(basePackages = {"com.example.travelbackend"})
public class TravelBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(TravelBackendApplication.class, args);
    }

}
