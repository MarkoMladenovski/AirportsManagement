package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// Main class to run the Spring Boot application
@SpringBootApplication
@EnableJpaRepositories("Repository")
public class AirportManagement {
    public static void main(String[] args) {
        SpringApplication.run(AirportManagement.class, args);
    }
}
