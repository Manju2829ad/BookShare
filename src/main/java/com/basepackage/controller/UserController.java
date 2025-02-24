package com.basepackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.basepackage.service.UserService;
import com.basepackage.Dto.UserDTO;
@RestController
@RequestMapping("/api/user/")
public class UserController {


     @Autowired
     private UserService userService;
     @PostMapping("/register")
     public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
         System.out.println("register method called");
         System.out.println(userDTO);
         System.out.println(userDTO.getMobileNumber());
         System.out.println(userDTO.getAge());
     
         try {
             // Validate if user already exists
             if (userDTO.getPassword() == null || userDTO.getPassword().trim().isEmpty()) {
                throw new IllegalArgumentException("Password cannot be null or empty");
            }
            
     
             // Save the user
             UserDTO savedUser = userService.saveUser(userDTO);
     
             return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
         
         } catch (Exception e) {
             e.printStackTrace(); // Log the actual error
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("Internal server error: " + e.getMessage());
         }
     }
     
    }
    