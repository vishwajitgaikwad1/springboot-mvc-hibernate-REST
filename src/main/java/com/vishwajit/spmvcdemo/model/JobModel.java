package com.vishwajit.spmvcdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job")
public class JobModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_id")
	private int id;
	
	@Column(name="job_title")
	private String jobTitle;
	
	@Column(name="job_description")	
	private String jobDescription;
	
	@Column(name="job_status")
	private String jobStatus;
	
	public JobModel() {
		
	}
	
	public JobModel(String jobTitle, String jobDescription, String jobStatus) {
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobStatus = jobStatus;
	}



	@Override
	public String toString() {
		return "JobModel [id=" + id + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription + ", jobStatus="
				+ jobStatus + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

}
