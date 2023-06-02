package fr.orionbs.experience_project.application.ouput;

import fr.orionbs.experience_project.adapter.persistence.exception.ExperiencePersistenceException;
import fr.orionbs.experience_project.domain.model.Experience;

public interface InsertExperiencePort {
    Experience insertExperience() throws ExperiencePersistenceException;
}
