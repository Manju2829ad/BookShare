package com.basepackage.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.basepackage.Dto.LoginDTO;
import com.basepackage.Dto.UserDTO;
import com.basepackage.entityMapper.EntityDTOMapper;
import com.basepackage.model.Login;
import com.basepackage.model.User;
import com.basepackage.repo.LoginRepo;
import com.basepackage.repo.UserRepo;


@Component
public class AuthServiceImpl implements AuthServiceI {

    @Autowired
    private UserService userService;

    @Autowired
    private EntityDTOMapper modelMapper;
    

    @Autowired
  private   LoginRepo loginrepo;

    @Autowired
    private UserRepo userRepository; // Assuming you have a repository to fetch user

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean validateUser(LoginDTO loginDto) throws Exception {
        if (loginDto.getEmailOrMobileNumber() == null || loginDto.getPassword() == null) {
            throw new IllegalArgumentException("Email/Mobile number and password cannot be null");
        }

                 
        System.out.println(loginDto.getEmailOrMobileNumber());

        User userEntity =new User();
System.out.println(userEntity.toString());
         User user=null;
        
        // Check if input is an email
        if (loginDto.getEmailOrMobileNumber().matches("^[\\w-\\.]+@([\\w-]+\\.)+[a-zA-Z]{2,7}$")) {
            System.out.println("Valid email detected");
             user = userRepository.findByEmail(loginDto.getEmailOrMobileNumber())
                    .orElse(null);
        } 
        // Check if input is a mobile number
        else if (loginDto.getEmailOrMobileNumber().matches("^\\d{10}$")) {
            System.out.println("Valid mobile number detected");

            System.out.println("printing mobile number...");
            System.out.println("???"+loginDto.getEmailOrMobileNumber());

             user = userRepository.findByMobileNumber(loginDto.getEmailOrMobileNumber().trim())
                    .orElse(null);

                    Login login =modelMapper.DtoToEntity(loginDto,Login.class);

                    login.setUser(user);
                    login.setLoginTimeStamp(LocalDateTime.now());
               Login  savedlogin=loginrepo.save(login);
            //    System.out.println(savedlogin);
              
        } else {
            throw new IllegalArgumentException("Invalid email or mobile number format");
        }

        if (user== null) {
            throw new IllegalArgumentException("User not found");
        }

        // ✅ Correct way to compare passwords
        if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return true; // Password is correct
        } else {
            throw new IllegalArgumentException("Invalid credentials");
        }
    }
}

