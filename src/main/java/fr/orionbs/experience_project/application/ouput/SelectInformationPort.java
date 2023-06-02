package fr.orionbs.experience_project.application.ouput;

import fr.orionbs.experience_project.adapter.persistence.exception.InformationPersistenceException;
import fr.orionbs.experience_project.domain.model.Information;

public interface SelectInformationPort {
    Information selectInformationById(Integer informationId) throws InformationPersistenceException;
}
