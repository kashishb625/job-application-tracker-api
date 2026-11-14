package com.Kashish.job_application_tracker.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="users")
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Please enter a name")
	@Column(nullable=false)
	private String name;
	
	@Email(message="Enter a valid email id")
	@NotBlank(message="Email is required")
	@Column(nullable=false, unique=true)
	private String email;
	
	@NotBlank(message="Password is required")
	@Size(min=6, message="Password must be atleast of 6 Characters")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$",
	        message = "Password must include uppercase, lowercase, a number, and a special character")
	@Column(nullable=false)
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<JobApplication> jobApplications;

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public List<JobApplication> getJobApplication() 
	{
		return jobApplications;
	}

	public void setJobApplication(List<JobApplication> jobApplications)
	{
		this.jobApplications = jobApplications;
	}
	
	

}
