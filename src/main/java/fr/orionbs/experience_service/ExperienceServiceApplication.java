package fr.orionbs.experience_service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ExperienceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExperienceServiceApplication.class, args);
    }

}
