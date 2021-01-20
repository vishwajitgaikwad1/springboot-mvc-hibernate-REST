package com.vishwajit.spmvcdemo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vishwajit.spmvcdemo.model.JobModel;
import com.vishwajit.spmvcdemo.service.JobService;

@RestController
@RequestMapping("/api")
public class R_JobController {
	
	private JobService jobService;
	
	@Autowired
	public R_JobController(JobService theJobService) {
		jobService = theJobService;
	}
	
	@GetMapping("/jobs")
	public List<JobModel> findAll(){
		return jobService.findAll();
	}
	
	
	//Get Single Employee
	@GetMapping("/jobs/{jobId}")
	public JobModel getJob(@PathVariable int jobId) {
		
		JobModel theJob = jobService.findById(jobId);
		if(theJob==null) {
			throw new RuntimeException("Job Id not found: "+ jobId);
			}
		return theJob;
		
	}
	//Add Employee
	@PostMapping("/jobs")
	public JobModel addJob(@RequestBody JobModel theJobModel) {
		theJobModel.setId(0);
		jobService.save(theJobModel);
		return theJobModel;
	}
	//Update Employee
	@PutMapping("/jobs")
	public JobModel updateJob(@RequestBody JobModel theJobModel) {
		jobService.save(theJobModel);
		return theJobModel;
	}
	//Delete Employee
	@DeleteMapping("/jobs/{jobId}")
	public String deleteJob(@PathVariable int jobId) {
		JobModel tempJob = jobService.findById(jobId);
		
		if(tempJob==null) {
			throw new RuntimeException("Job Id not Found: "+ jobId);
		}
		jobService.deleteById(jobId);
		return "Deleted employee id: "+jobId;
	}

}
