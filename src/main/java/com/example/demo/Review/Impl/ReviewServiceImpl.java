package com.example.demo.Review.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Company.Company;
import com.example.demo.Company.CompanyService;
import com.example.demo.Review.Review;
import com.example.demo.Review.ReviewRepository;
import com.example.demo.Review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewRepository repository;
	private CompanyService companyService;
	
	public ReviewServiceImpl(ReviewRepository repository,CompanyService companyService) {
		this.repository = repository;
		this.companyService = companyService;
	}

	@Override
	public List<Review> getAllReviews(Long companyId) {
		List<Review> reviews = repository.findByCompanyId(companyId);
		return reviews;
	}

	@Override
	public boolean addReview(Long companyId, Review review) {
		
		Company company = companyService.getCompanyById(companyId);
		
		if(company !=null) {
			review.setCompany(company);
			System.out.println("company not null, company is : "+company);
			repository.save(review);
			return true;
		}
		System.out.println("Company null");
		return false;
		
	}
	@Override
	public boolean updateReview(Long id, Long companyId, Review review) {
		Company company = companyService.getCompanyById(companyId);
		if(company!=null ) {
			review.setCompany(company);
			review.setId(id);
			repository.save(review);
			return true;
		}
		return false;
	}

	@Override
	public boolean delReview(Long companyId, Long id) {
		Company company = companyService.getCompanyById(companyId);
		if(company !=null && repository.existsById(id)) {
			Review review = repository.findById(id).orElse(null);
			review.setCompany(null);
			company.getReviews().remove(review);
			repository.delete(review);
			return true;
		}
		return false;
	}

}
