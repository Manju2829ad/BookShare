package com.basepackage.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@Column(name="user_email",unique = true,nullable = false)
	private String  email;

	@Column(name="user_mobileNumber",unique = true,nullable = false)
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


	@Column(name="user_created_at")
    private  LocalDateTime createdAt;

	@Column(name="user_login")
	@OneToMany(mappedBy="user",cascade = CascadeType.PERSIST,orphanRemoval = false)
	private List<Login> login;
	
     



	public void updatePassword(String password){

		this.password=password;
	}

	public void updateEmail(String email){	
	
		this.email=email;

	}	

	public void updateMobileNumber(String mobileNumber){
		this.mobileNumber= mobileNumber;
	}




}
