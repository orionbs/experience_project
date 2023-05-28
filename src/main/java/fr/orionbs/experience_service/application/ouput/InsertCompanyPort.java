package fr.orionbs.experience_service.application.ouput;

import fr.orionbs.experience_service.domain.model.Company;

public interface InsertCompanyPort {
    Company insertCompany(Company company);
}
