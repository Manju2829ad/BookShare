package com.basepackage.service;

import java.util.Optional;

import com.basepackage.Dto.LoginDTO;

public interface AuthServiceI {



    public  boolean validateUser(LoginDTO loginDto) throws Exception;


   
}
