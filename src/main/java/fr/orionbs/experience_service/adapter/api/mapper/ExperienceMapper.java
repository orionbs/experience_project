package fr.orionbs.experience_service.adapter.api.mapper;

import fr.orionbs.experience_service.adapter.api.response.ExperienceResponse;
import fr.orionbs.experience_service.adapter.persistence.entity.ExperienceEntity;
import org.springframework.stereotype.Component;

@Component
public class ExperienceMapper {

    public ExperienceResponse toResponse(ExperienceEntity experienceEntity) {

        ExperienceResponse experienceResponse = new ExperienceResponse();
        experienceResponse.setId(experienceEntity.getId());
        experienceResponse.setTitle(experienceEntity.getTitle());
        experienceResponse.setDescription(experienceEntity.getDescription());
        experienceResponse.setStart(experienceEntity.getStart());
        experienceResponse.setEnd(experienceEntity.getEnd() == null ? null : experienceEntity.getEnd());

        ExperienceResponse.CompanyResponse companyResponse = new ExperienceResponse.CompanyResponse();
        companyResponse.setName(experienceEntity.getCompany().getName());
        companyResponse.setDescription(experienceEntity.getCompany().getDescription());

        experienceResponse.setCompany(companyResponse);

        experienceResponse.getTasks().addAll(
                experienceEntity.getTasks().stream()
                        .map(taskEntity -> {
                            ExperienceResponse.TaskResponse taskResponse = new ExperienceResponse.TaskResponse();
                            taskResponse.setIcon(taskEntity.getIcon());
                            taskResponse.setValue(taskEntity.getValue());
                            return taskResponse;
                        })
                        .toList()
        );

        experienceResponse.getLanguages().addAll(experienceEntity.getLanguages());
        experienceResponse.getArchitectures().addAll(experienceEntity.getArchitectures());
        experienceResponse.getDesignPatterns().addAll(experienceEntity.getDesignPatterns());
        experienceResponse.getDeployments().addAll(experienceEntity.getDeployments());
        experienceResponse.getEnvironments().addAll(experienceEntity.getEnvironments());

        return experienceResponse;
    }

}
