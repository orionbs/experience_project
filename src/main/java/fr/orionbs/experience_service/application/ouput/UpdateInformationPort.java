package fr.orionbs.experience_service.application.ouput;

import fr.orionbs.experience_service.adapter.persistence.exception.InformationPersistenceException;
import fr.orionbs.experience_service.domain.model.Information;

public interface UpdateInformationPort {
    Information updateInformation(Information information) throws InformationPersistenceException;
}
