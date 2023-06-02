package fr.orionbs.experience_project.adapter.persistence.repository;

import fr.orionbs.experience_project.adapter.persistence.entity.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InformationRepository extends JpaRepository<InformationEntity, Integer> {
    Optional<InformationEntity> findInformationEntityById(Integer id);
}
