package com.example.demo.Review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Review.Impl.ReviewServiceImpl;

@RestController
@RequestMapping("/company/{companyId}/reviews")
public class ReviewController {
	private ReviewServiceImpl service;
	
	public ReviewController(ReviewServiceImpl service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Review>> getReviews(@PathVariable Long companyId){
		List<Review> reviews = service.getAllReviews(companyId);
		return new ResponseEntity<>(reviews,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
		
		if(service.addReview(companyId,review)) {
			
		return new ResponseEntity<>("Review added succesfully", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Review not added succesfully", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateReview(@PathVariable Long id,@PathVariable Long companyId, @RequestBody Review review){
		if(service.updateReview(id,companyId,review)) {
			return new ResponseEntity<>("Review updated succesfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("Review not updated succesfully",HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long id){
		if(service.delReview(companyId,id)) {
			return new ResponseEntity<>("Review deleted succesfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("Review not updated succesfully",HttpStatus.BAD_REQUEST);
	}

}
