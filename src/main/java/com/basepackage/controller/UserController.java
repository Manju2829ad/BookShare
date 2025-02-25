package com.basepackage.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import com.basepackage.service.AuthServiceImpl;
import com.basepackage.service.UserService;
import com.basepackage.util.JwtService;
import com.basepackage.Dto.LoginDTO;
import com.basepackage.Dto.UserDTO;
import com.basepackage.model.Login;
import com.basepackage.model.User;
import com.basepackage.repo.LoginRepo;
import com.basepackage.response.AuthResponse; // New response DTO

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private LoginRepo loginRepository;

    @Autowired
    private UserService userService; // Fixed missing @Autowired

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
System.out.println("form registration");
        System.out.println(userDTO.toString());
        try {
            if (userDTO.getPassword() == null || userDTO.getPassword().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Password cannot be empty");
            }

            UserDTO savedUser = userService.saveUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {

            System.out.println(loginDTO.toString());
            boolean isAuthenticated = authService.validateUser(loginDTO);

            System.out.println(isAuthenticated);
            if (isAuthenticated) {
                String token = jwtService.generateToken(loginDTO.getEmailOrMobileNumber());

                // Sending JWT in a structured response
                com.basepackage.response.AuthResponse response = new com.basepackage.response.AuthResponse("Login successful", token);
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



    @PostMapping("/logout/{userId}")

    public ResponseEntity<?> logout(@PathVariable Long userId){

        Optional<Login> loginRecord = loginRepository.findByUserIdOrderByLoginTimeStampDesc(userId);;

        if(loginRecord.isPresent()){

            Login login= loginRecord.get();
            login.setLogoutTimeStamp(LocalDateTime.now());

            loginRepository.save(login);

            return ResponseEntity.ok("Logged out successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User session not found.");   
    }
}
