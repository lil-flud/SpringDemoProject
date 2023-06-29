package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

/*
ALT + Enter and then click "On demand Static Import".
 */
@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    1L,
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    LocalDate.of(2000, JANUARY, 5)
            );
            Student alyx = new Student(
                    "alyx",
                    "alyx.chaivre@gmail.com",
                    LocalDate.of(2004, JANUARY, 5)
            );
            repository.saveAll(
                    List.of(mariam, alyx)
            );
        };
    }
}
