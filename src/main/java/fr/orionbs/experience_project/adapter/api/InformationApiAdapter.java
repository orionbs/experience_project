package fr.orionbs.experience_project.adapter.api;

import fr.orionbs.experience_project.application.input.AddInformationUseCase;
import fr.orionbs.experience_project.application.input.AssociateInformationUseCase;
import fr.orionbs.experience_project.domain.model.Information;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class InformationApiAdapter {

    private final AddInformationUseCase addInformationUseCase;
    private final AssociateInformationUseCase associateInformationUseCase;

    @Operation(summary = "Add an information")
    @PostMapping(path = "add-information")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Information addInformation(@RequestParam String title,
                                      @RequestParam String description,
                                      @RequestParam LocalDate start,
                                      @RequestParam(required = false) LocalDate end) {

        // First, initiate the information.
        Information information = new Information();
        information.setTitle(title);
        information.setDescription(description);
        information.setStart(start);
        information.setEnd(end);

        // Second, proceed to the use case.
        information = addInformationUseCase.addInformation(information);

        // Third, return the information.
        return information;

    }

    @Operation(summary = "Associate an information with an experience")
    @PatchMapping(path = "associate-information-with-experience")
    @ResponseStatus(code = HttpStatus.OK)
    public Information associateInformationWithExperience(@RequestParam Integer informationId,
                                                          @RequestParam Integer experienceId) {

        // First, initiate an empty experience.
        Information information = new Information();

        // Second, proceed to use case.
        information = associateInformationUseCase.associateInformationWithExperience(informationId, experienceId);

        // Third, return the information.
        return information;
    }

}
