package fr.orionbs.experience_service.application.ouput;

import fr.orionbs.experience_service.adapter.persistence.exception.ExperiencePersistenceException;
import fr.orionbs.experience_service.domain.model.Experience;

public interface SelectExperiencePort {
    Experience selectExperienceById(Integer experienceId) throws ExperiencePersistenceException;
}
