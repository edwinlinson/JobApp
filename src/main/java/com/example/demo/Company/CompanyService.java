package com.example.demo.Company;

import java.util.List;

public interface CompanyService {

	List<Company> getAllCompanies();
	void createCompany(Company company);
	boolean updateCompany(Company updatedCompany, Long id);
	boolean deleteCompany(Long id);
}
