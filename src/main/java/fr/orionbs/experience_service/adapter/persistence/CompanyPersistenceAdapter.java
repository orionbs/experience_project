package fr.orionbs.experience_service.adapter.persistence;

import fr.orionbs.experience_service.application.ouput.InsertCompanyPort;
import fr.orionbs.experience_service.domain.model.Company;
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
