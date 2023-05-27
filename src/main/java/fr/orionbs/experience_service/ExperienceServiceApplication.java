package fr.orionbs.experience_service;

import fr.orionbs.experience_service.adapter.persistence.entity.ExperienceEntity;
import fr.orionbs.experience_service.adapter.persistence.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class ExperienceServiceApplication implements CommandLineRunner {

    private final ExperienceRepository experienceRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExperienceServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ExperienceEntity experienceEntity = new ExperienceEntity();
        experienceEntity.setTitle("title");
        experienceEntity.setDescription("description");
        experienceEntity.setStart(LocalDate.now());

        ExperienceEntity.CompanyEntity companyEntity = new ExperienceEntity.CompanyEntity();
        companyEntity.setName("company_name");
        companyEntity.setDescription("company_description");
        experienceEntity.setCompany(companyEntity);

        experienceEntity.getLanguages().add("language");
        experienceEntity.getDesignPatterns().add("design_pattern");
        experienceEntity.getArchitectures().add("architecture");
        experienceEntity.getDeployments().add("deployment");
        experienceEntity.getEnvironments().add("environment");

        ExperienceEntity.TaskEntity taskEntity = new ExperienceEntity.TaskEntity();
        taskEntity.setIcon("settings");
        taskEntity.setValue("task_value");
        experienceEntity.getTasks().add(taskEntity);
        experienceEntity.getTasks().add(taskEntity);
        experienceEntity.getTasks().add(taskEntity);

        experienceRepository.insert(experienceEntity);
    }
}
