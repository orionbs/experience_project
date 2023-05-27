package fr.orionbs.experience_service.adapter.persistence;

import fr.orionbs.experience_service.adapter.persistence.entity.InformationEntity;
import fr.orionbs.experience_service.adapter.persistence.exception.InformationPersistenceException;
import fr.orionbs.experience_service.adapter.persistence.mapper.InformationPersistenceMapper;
import fr.orionbs.experience_service.adapter.persistence.repository.InformationRepository;
import fr.orionbs.experience_service.application.ouput.InsertInformationPort;
import fr.orionbs.experience_service.application.ouput.SelectInformationPort;
import fr.orionbs.experience_service.application.ouput.UpdateInformationPort;
import fr.orionbs.experience_service.domain.model.Information;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@RequiredArgsConstructor
public class InformationPersistenceAdapter implements InsertInformationPort, SelectInformationPort, UpdateInformationPort {

    private final Log LOGGER = LogFactory.getLog(InformationPersistenceAdapter.class);

    private final InformationRepository informationRepository;
    private final InformationPersistenceMapper informationPersistenceMapper;

    @Override
    public Information insertInformation(Information information) throws InformationPersistenceException {

        // First, initiate empty information.
        InformationEntity informationEntity = new InformationEntity();

        // Second, fill variables that are required.
        // Title
        if (information.getTitle() == null || information.getTitle().isBlank()) {
            throw new InformationPersistenceException("Information title is null or blank.");
        } else {
            informationEntity.setTitle(information.getTitle());
        }
        // Description
        if (information.getDescription() == null || information.getDescription().isBlank()) {
            throw new InformationPersistenceException("Information description is null or blank.");
        } else {
            informationEntity.setDescription(information.getDescription());
        }
        // Start
        if (information.getStart() == null) {
            throw new InformationPersistenceException("Information start is null.");
        } else {
            informationEntity.setStart(Timestamp.valueOf(information.getStart().atStartOfDay()));
        }

        // End, this one can be null
        if (information.getEnd() != null) {
            informationEntity.setEnd(Timestamp.valueOf(information.getEnd().atStartOfDay()));
        }

        // Third, the entity is correctly filled, so we can persist it.
        try {
            informationEntity = informationRepository.save(informationEntity);
        } catch (Exception exception) {
            LOGGER.debug(exception.getMessage());
            throw new InformationPersistenceException("Information insertion failed.");
        }

        return informationPersistenceMapper.toInformation(informationEntity);

    }

    @Override
    public Information selectInformationById(Integer informationId) throws InformationPersistenceException {
        return informationRepository.findInformationEntityById(informationId).map(informationPersistenceMapper::toInformation).orElseThrow(() -> new InformationPersistenceException("Information is unknown with this id."));
    }

    @Override
    public Information updateInformation(Information information) throws InformationPersistenceException {
        return null;
    }

}
