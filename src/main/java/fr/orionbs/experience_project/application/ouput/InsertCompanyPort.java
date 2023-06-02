package fr.orionbs.experience_project.application.ouput;

import fr.orionbs.experience_project.domain.model.Company;

public interface InsertCompanyPort {
    Company insertCompany(Company company);
}
