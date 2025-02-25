package com.basepackage.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserDTO{


    public UserDTO(String emailOrMobileNumber) {
        //TODO Auto-generated constructor stub
    }

    @JsonProperty("user_id")
	private Long id;
	

    @JsonProperty("user_mobile_number")
	private String mobileNumber;

    @JsonProperty("user_email")
	private String email;
	
    
    @JsonProperty("user_password")
	private String password;
	
    @JsonProperty("user_role")
	private String role;
	
    @JsonProperty("user_age")
	private Integer age;
	
    @JsonProperty("user_address")
	private String address;
	
    @JsonProperty("user_pincode")
	private Long pincode;

    @Override
    public String toString() {
        return "UserDTO [id=" + id + ", mobileNumber=" + mobileNumber + ", email=" + email + ", password=" + password
                + ", role=" + role + ", age=" + age + ", address=" + address + ", pincode=" + pincode + "]";
    }





}