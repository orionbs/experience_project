package fr.orionbs.experience_project.domain.service;

import fr.orionbs.experience_project.adapter.persistence.exception.ExperiencePersistenceException;
import fr.orionbs.experience_project.adapter.persistence.exception.InformationPersistenceException;
import fr.orionbs.experience_project.application.input.AssociateInformationUseCase;
import fr.orionbs.experience_project.application.input.InitExperienceUseCase;
import fr.orionbs.experience_project.application.ouput.InsertExperiencePort;
import fr.orionbs.experience_project.application.ouput.SelectExperiencePort;
import fr.orionbs.experience_project.application.ouput.SelectInformationPort;
import fr.orionbs.experience_project.application.ouput.UpdateExperiencePort;
import fr.orionbs.experience_project.domain.exception.ExperienceInitiationException;
import fr.orionbs.experience_project.domain.exception.InformationAssociationException;
import fr.orionbs.experience_project.domain.model.Experience;
import fr.orionbs.experience_project.domain.model.Information;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExperienceService implements InitExperienceUseCase, AssociateInformationUseCase {

    private final Log LOGGER = LogFactory.getLog(ExperienceService.class);

    private final InsertExperiencePort insertExperiencePort;
    private final SelectExperiencePort selectExperiencePort;
    private final SelectInformationPort selectInformationPort;
    private final UpdateExperiencePort updateExperiencePort;

    @Override
    public Experience initExperience() {

        try {
            return insertExperiencePort.insertExperience();
        } catch (ExperiencePersistenceException experiencePersistenceException) {
            LOGGER.debug(experiencePersistenceException.getMessage());
            throw new ExperienceInitiationException();
        }

    }

    @Override
    public Information associateInformationWithExperience(Integer informationId, Integer experienceId) {

        try {

            // First, select the experience with his id.
            Experience experience = selectExperiencePort.selectExperienceById(experienceId);

            // Second, select the information with his id.
            Information information = selectInformationPort.selectInformationById(informationId);

            // Third, associate the information to experience.
            experience.setInformation(Information.builder().id(information.getId()).build());

            // Fourth, update the experience.
            experience = updateExperiencePort.updateExperienceWithInformation(experience);

            // Third, return the information.
            return information;

        } catch (ExperiencePersistenceException | InformationPersistenceException persistenceException) {
            LOGGER.debug(persistenceException.getMessage());
            throw new InformationAssociationException();
        }

    }

}
