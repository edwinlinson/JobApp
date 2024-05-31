package com.example.demo.Company.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Company.Company;
import com.example.demo.Company.CompanyRepo;
import com.example.demo.Company.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyRepo companyRepo;
	

	public CompanyServiceImpl(CompanyRepo companyRepo) {
		this.companyRepo = companyRepo;
	}


	@Override
	public List<Company> getAllCompanies() {
		return companyRepo.findAll();
		}


	@Override
	public void createCompany(Company company) {
		companyRepo.save(company);
	}


	@Override
	public boolean updateCompany(Company updatedCompany, Long id) {
		Optional<Company> optionalCompany = companyRepo.findById(id);
		if(optionalCompany.isPresent()) {
			Company company = optionalCompany.get();
			company.setDescription(updatedCompany.getDescription());
			company.setJobs(updatedCompany.getJobs());
			company.setName(updatedCompany.getName());
			companyRepo.save(company);
			return true;
			}
		return false;
	}


	@Override
	public boolean deleteCompany(Long id) {
		try {
			companyRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public Company getCompanyById(Long id) {
		return companyRepo.findById(id).orElse(null);
	}

}
