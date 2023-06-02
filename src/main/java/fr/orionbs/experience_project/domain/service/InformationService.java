package fr.orionbs.experience_project.domain.service;

import fr.orionbs.experience_project.adapter.persistence.exception.InformationPersistenceException;
import fr.orionbs.experience_project.application.input.AddInformationUseCase;
import fr.orionbs.experience_project.application.ouput.InsertInformationPort;
import fr.orionbs.experience_project.application.ouput.SelectInformationPort;
import fr.orionbs.experience_project.application.ouput.UpdateInformationPort;
import fr.orionbs.experience_project.domain.exception.InformationAdditionException;
import fr.orionbs.experience_project.domain.model.Information;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InformationService implements AddInformationUseCase {

    private final Log LOGGER = LogFactory.getLog(InformationService.class);

    private final InsertInformationPort insertInformationPort;
    private final UpdateInformationPort updateInformationPort;
    private final SelectInformationPort selectInformationPort;

    @Override
    public Information addInformation(Information information) {

        try {
            return insertInformationPort.insertInformation(information);
        } catch (InformationPersistenceException informationPersistenceException) {
            LOGGER.debug(informationPersistenceException.getMessage());
            throw new InformationAdditionException();
        }

    }

}
