package fr.orionbs.experience_project.application.input;

import fr.orionbs.experience_project.domain.model.Information;

public interface AssociateInformationUseCase {
    Information associateInformationWithExperience(Integer informationId, Integer experienceId);
}
