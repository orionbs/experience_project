package fr.orionbs.experience_project.adapter.persistence;

import fr.orionbs.experience_project.application.ouput.InsertCompanyPort;
import fr.orionbs.experience_project.domain.model.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyPersistenceAdapter implements InsertCompanyPort {
    @Override
    public Company insertCompany(Company company) {
        return null;
    }
}
