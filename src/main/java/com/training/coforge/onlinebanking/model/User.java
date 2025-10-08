package com.training.coforge.onlinebanking.model;

import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="users")
@Data                // Generates Getters, Setters, toString, equals, hashCode
@NoArgsConstructor     // Generates No-args constructor
@AllArgsConstructor 

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "user_seq")
	@SequenceGenerator(name="user_seq",initialValue = 1000,allocationSize = 1)
	private Long userId;

	@Column(nullable=false)
	private String firstName;

	@Column(nullable=false)
	private String lastName;

	@Column(nullable=false)
	private Date dob;

	@Column(nullable=false)
	private String email;
	
	@Column(nullable = false)
	private String password;

	@Column(nullable=false,name="phone_no",unique=true)
	private String phoneNumber;

	@Column(unique=true,nullable=false)
	private String aadharNumber;

	@Column(nullable=false)
	private String residentialAddress;

	@Column(nullable=false)
	private String permanentAddress;

	@Column(name="occupation")
	private String occupation;

	@CreationTimestamp
	@Column(name="created_at", updatable=false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name="updated_at")
	private LocalDateTime updatedAt;

}	
