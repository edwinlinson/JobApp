package com.example.demo.Job;

import java.util.List;


public interface JobService {
	
	List<Job> findAll();
	void createJob(Job job);
	Job getById(Long id);
	boolean deleteById(Long id);
	boolean updateJob(Long id, Job job);
}
