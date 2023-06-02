package fr.orionbs.experience_project.adapter.persistence.mapper;

import fr.orionbs.experience_project.adapter.persistence.entity.ExperienceEntity;
import fr.orionbs.experience_project.domain.model.Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperiencePersistenceMapper {

    public Experience toExperience(ExperienceEntity experienceEntity) {
        Experience experience = new Experience();
        experience.setId(experienceEntity.getId());
        return experience;
    }

}
