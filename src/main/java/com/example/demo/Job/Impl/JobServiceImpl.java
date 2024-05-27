package com.example.demo.Job.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Job.Job;
import com.example.demo.Job.JobService;

@Service
public class JobServiceImpl implements JobService{
	private Long nextId =1L; 
	List<Job> jobs = new ArrayList<>();
	@Override
	public List<Job> findAll() {
		return jobs;
	}

	@Override
	public void createJob(Job job) {
		job.setId(nextId++);
		jobs.add(job);
	}

	@Override
	public Job getById(Long id) {
		for(Job job: jobs) {
			if(job.getId().equals(id)) {
				return job;
			}
		}
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		for(Job job: jobs ) {
			if(job.getId().equals(id)) {
				jobs.remove(job);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteIterator(Long id) {
		Iterator<Job> iterator = jobs.iterator();
		while(iterator.hasNext()) {
			Job job = iterator.next();
			System.out.println(" Job is : "+job);
			iterator.remove();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateJob(Long id, Job Updatedjob) {
		for(Job job: jobs) {
			if(job.getId().equals(id)) {
				job.setDescription(Updatedjob.getDescription());
				job.setLocation(Updatedjob.getLocation());
				job.setMaxSalary(Updatedjob.getMaxSalary());
				job.setMinSalary(Updatedjob.getMinSalary());
				job.setTitle(Updatedjob.getTitle());
				return true;
			}
		}
		return false;
	}

}
