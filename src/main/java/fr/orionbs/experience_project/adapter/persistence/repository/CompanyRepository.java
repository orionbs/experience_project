package fr.orionbs.experience_project.adapter.persistence.repository;

import fr.orionbs.experience_project.adapter.persistence.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
    Optional<CompanyEntity> findCompanyEntityById(Integer id);
}
