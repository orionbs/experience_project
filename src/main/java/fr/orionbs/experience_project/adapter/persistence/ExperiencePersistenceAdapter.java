package fr.orionbs.experience_project.adapter.persistence;

import fr.orionbs.experience_project.adapter.persistence.entity.ExperienceEntity;
import fr.orionbs.experience_project.adapter.persistence.entity.InformationEntity;
import fr.orionbs.experience_project.adapter.persistence.exception.ExperiencePersistenceException;
import fr.orionbs.experience_project.adapter.persistence.mapper.ExperiencePersistenceMapper;
import fr.orionbs.experience_project.adapter.persistence.repository.ExperienceRepository;
import fr.orionbs.experience_project.application.ouput.InsertExperiencePort;
import fr.orionbs.experience_project.application.ouput.SelectExperiencePort;
import fr.orionbs.experience_project.application.ouput.UpdateExperiencePort;
import fr.orionbs.experience_project.domain.model.Experience;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExperiencePersistenceAdapter implements InsertExperiencePort, SelectExperiencePort, UpdateExperiencePort {

    private final Log LOGGER = LogFactory.getLog(ExperiencePersistenceAdapter.class);

    private final ExperienceRepository experienceRepository;
    private final ExperiencePersistenceMapper experiencePersistenceMapper;

    @Override
    public Experience insertExperience() throws ExperiencePersistenceException {

        // First, initiate empty experience.
        ExperienceEntity experienceEntity = new ExperienceEntity();

        // Second, we can persist it.
        try {
            experienceEntity = experienceRepository.save(experienceEntity);
        } catch (Exception exception) {
            LOGGER.debug(exception.getMessage());
            throw new ExperiencePersistenceException("Experience insertion failed.");
        }

        return experiencePersistenceMapper.toExperience(experienceEntity);

    }

    @Override
    public Experience selectExperienceById(Integer experienceId) throws ExperiencePersistenceException {
        return experienceRepository.findExperienceEntityById(experienceId).map(experiencePersistenceMapper::toExperience).orElseThrow(() -> new ExperiencePersistenceException("Unknown experience with this id."));
    }

    @Override
    public Experience updateExperienceWithInformation(Experience experience) throws ExperiencePersistenceException {

        ExperienceEntity experienceEntity;

        if (experience.getId() == null) {
            throw new ExperiencePersistenceException("Experience id is null.");
        } else {
            experienceEntity = experienceRepository.findExperienceEntityById(experience.getId()).orElseThrow(() -> new ExperiencePersistenceException("Information is unknown with this id."));
        }

        if (experience.getInformation() == null || experience.getInformation().getId() == null) {
            throw new ExperiencePersistenceException("Information is null or his id is null.");
        } else {
            experienceEntity.setInformation(InformationEntity.builder().id(experience.getInformation().getId()).build());
        }

        try {
            experienceEntity = experienceRepository.save(experienceEntity);
        } catch (Exception exception) {
            LOGGER.debug(exception.getMessage());
            throw new ExperiencePersistenceException("Experience insertion failed.");
        }

        return experiencePersistenceMapper.toExperience(experienceEntity);
    }
}
