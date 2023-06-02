package fr.orionbs.experience_project.adapter.persistence.mapper;

import fr.orionbs.experience_project.adapter.persistence.entity.InformationEntity;
import fr.orionbs.experience_project.domain.model.Information;
import org.springframework.stereotype.Component;

@Component
public class InformationPersistenceMapper {

    public Information toInformation(InformationEntity informationEntity) {
        Information information = new Information();
        information.setId(informationEntity.getId());
        information.setTitle(informationEntity.getTitle());
        information.setDescription(informationEntity.getDescription());
        information.setStart(informationEntity.getStart().toLocalDateTime().toLocalDate());
        information.setEnd(informationEntity.getEnd() == null ? null : informationEntity.getEnd().toLocalDateTime().toLocalDate());
        return information;
    }
}
