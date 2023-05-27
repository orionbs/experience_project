package fr.orionbs.experience_service.adapter.persistence.repository;

import fr.orionbs.experience_service.adapter.persistence.entity.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Integer> {
    Optional<ExperienceEntity> findExperienceEntityById(Integer id);
}
