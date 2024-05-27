package com.example.demo.Job.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Job.Job;
import com.example.demo.Job.JobRepo;
import com.example.demo.Job.JobService;

@Service
public class JobServiceImpl implements JobService{
//	private Long nextId =1L; 
//	List<Job> jobs = new ArrayList<>();
	
	private JobRepo jobRepo;
	
	
	public JobServiceImpl(JobRepo jobRepo) {
	this.jobRepo = jobRepo;
}

	@Override
	public List<Job> findAll() {
		return jobRepo.findAll();
	}

	@Override
	public void createJob(Job job) {
		jobRepo.save(job);
	}

	@Override
	public Job getById(Long id) {
		return jobRepo.findById(id).orElse(null);
	}

	@Override
	public boolean deleteById(Long id) {
		try {
		jobRepo.deleteById(id);
		return true;
		}catch(Exception e) {
			return false;
		}
		
	}

//	@Override
//	public boolean deleteIterator(Long id) {
//		Iterator<Job> iterator = jobs.iterator();
//		while(iterator.hasNext()) {
//			Job job = iterator.next();
//			System.out.println(" Job is : "+job);
//			iterator.remove();
//			return true;
//		}
//		return false;
//	}

	@Override
	public boolean updateJob(Long id, Job Updatedjob) {
		Optional<Job> optionalJob = jobRepo.findById(id);
			if(optionalJob.isPresent()) {
				Job job = optionalJob.get();
				job.setDescription(Updatedjob.getDescription());
				job.setLocation(Updatedjob.getLocation());
				job.setMaxSalary(Updatedjob.getMaxSalary());
				job.setMinSalary(Updatedjob.getMinSalary());
				job.setTitle(Updatedjob.getTitle());
				jobRepo.save(job);
				return true;
			}
		return false;
	}

}
