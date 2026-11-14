package com.Kashish.job_application_tracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kashish.job_application_tracker.entity.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>
{

	List<JobApplication> findJobsByUserId(Long userId);
	Optional<JobApplication> findByJobIdAndUserId(Long jobId, Long userId);
}
