package fr.orionbs.experience_service.application.input;

import fr.orionbs.experience_service.domain.model.Information;

public interface AssociateInformationUseCase {
    Information associateInformationWithExperience(Integer informationId, Integer experienceId);
}
