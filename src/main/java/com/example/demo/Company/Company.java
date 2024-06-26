package com.example.demo.Company;

import java.util.List;

import com.example.demo.Job.Job;
import com.example.demo.Review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
public class Company {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	private String name;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Job> jobs;
	
	@JsonIgnore
	@ToString.Exclude
	@OneToMany(mappedBy = "company")
	private List<Review> reviews;
}
