package fr.orionbs.experience_service.adapter.persistence.repository;

import fr.orionbs.experience_service.adapter.persistence.entity.ExperienceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ExperienceRepository extends MongoRepository<ExperienceEntity, String> {

    Optional<ExperienceEntity> findFirstByOrderByStartDesc();

}
