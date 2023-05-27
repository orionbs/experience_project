package fr.orionbs.experience_service.adapter.api;

import fr.orionbs.experience_service.adapter.exception.UnknownExperienceException;
import fr.orionbs.experience_service.adapter.api.mapper.ExperienceMapper;
import fr.orionbs.experience_service.adapter.api.response.ExperienceResponse;
import fr.orionbs.experience_service.adapter.persistence.entity.ExperienceEntity;
import fr.orionbs.experience_service.adapter.persistence.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ExperienceApiAdapter {

    // Repository
    private final ExperienceRepository experienceRepository;

    // Mapper
    private final ExperienceMapper experienceMapper;

    @GetMapping(path = "select-experiences")
    public List<ExperienceResponse> selectExperiences() {

        // First, we need to find experiences from the persistence.
        List<ExperienceEntity> experienceEntities = experienceRepository.findAll();

        // Second, we need to convert the experience's entities to experiences response.
        List<ExperienceResponse> experienceResponses = experienceEntities.stream()
                .map(experienceMapper::toResponse)
                .sorted(Comparator.comparing(ExperienceResponse::getStart).reversed())
                .toList();

        // Third, we can return our list.
        return experienceResponses;

    }

    @GetMapping(path = "select-last-experience")
    public ExperienceResponse selectLastExperience() {

        // First, we need to find the last experience from the persistence.
        Optional<ExperienceEntity> experienceEntityOptional = experienceRepository.findFirstByOrderByStartDesc();

        // Second check, there is an experience in the optional, or throw UnknownExperience.
        if (experienceEntityOptional.isEmpty()) {
            throw new UnknownExperienceException();
        }

        // Third, we need to convert the experience and return it.
        return experienceMapper.toResponse(experienceEntityOptional.get());

    }

}
