package com.Kashish.job_application_tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kashish.job_application_tracker.entity.User;

public interface UserRespository extends JpaRepository<User, Long>
{

	Optional<User> findUserByEmail(String email);
	boolean existsByEmail(String email);
}
