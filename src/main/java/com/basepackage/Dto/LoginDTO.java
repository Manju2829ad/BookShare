package com.basepackage.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginDTO {
    
    
    // @JsonIgnore
    @JsonProperty("emailOrMobileNumber")
 private  String emailOrMobileNumber;


// @JsonIgnore
@JsonProperty("password")
 private String password;





 
}
