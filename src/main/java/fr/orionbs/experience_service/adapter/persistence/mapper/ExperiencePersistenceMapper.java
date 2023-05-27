package fr.orionbs.experience_service.adapter.persistence.mapper;

import fr.orionbs.experience_service.adapter.persistence.entity.ExperienceEntity;
import fr.orionbs.experience_service.domain.model.Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperiencePersistenceMapper {

    public Experience toExperience(ExperienceEntity experienceEntity) {
        Experience experience = new Experience();
        experience.setId(experienceEntity.getId());
        return experience;
    }

}
