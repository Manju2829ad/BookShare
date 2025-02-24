package com.basepackage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_email")
	private String  email;

	@Column(name="user_mobileNumber")
	private String mobileNumber;

	@Column(name="user_password")
	private String password;
	
	@Column(name="user_role")
	private String role;
	
	
	@Column(name="user_age")
	private Integer age; // ✅ Allows null values
	
	
	@Column(name="user_address")
	private String address;
	
	@Column(name="user_pincode")
	private Long pincode;
	
}
