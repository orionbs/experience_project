package fr.orionbs.experience_service.adapter.api;

import fr.orionbs.experience_service.adapter.api.mapper.ExperienceMapper;
import fr.orionbs.experience_service.application.input.InitExperienceUseCase;
import fr.orionbs.experience_service.domain.model.Experience;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExperienceApiAdapter {

    private final InitExperienceUseCase initExperienceUseCase;

    // Mapper
    private final ExperienceMapper experienceMapper;

    @Operation(summary = "Initiate an experience")
    @PostMapping(path = "init-experience")
    @ResponseStatus(code = HttpStatus.OK)
    public Experience initExperience() {

        // First, initiate an empty experience.
        Experience experience = new Experience();

        // Second, proceed to use case.
        experience = initExperienceUseCase.initExperience();

        // Third, return the experience.
        return experience;

    }

}
