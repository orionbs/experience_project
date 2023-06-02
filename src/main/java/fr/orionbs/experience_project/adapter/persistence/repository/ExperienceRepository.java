package fr.orionbs.experience_project.adapter.persistence.repository;

import fr.orionbs.experience_project.adapter.persistence.entity.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Integer> {
    Optional<ExperienceEntity> findExperienceEntityById(Integer id);
}
