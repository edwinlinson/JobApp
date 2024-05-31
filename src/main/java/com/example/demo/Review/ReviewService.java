package com.example.demo.Review;

import java.util.List;

public interface ReviewService {
	List<Review> getAllReviews(Long companyId);

	boolean addReview(Long companyId, Review review); 
	boolean updateReview(Long id, Long companyId, Review review);
	public boolean delReview(Long companyId, Long id);
}
