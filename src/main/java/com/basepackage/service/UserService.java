package com.basepackage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.basepackage.Dto.UserDTO;
import com.basepackage.entityMapper.EntityDTOMapper;
import com.basepackage.model.User;
import com.basepackage.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo  repo;
	
	@Autowired
	private EntityDTOMapper entityDTOMapper;
	
	private  final BCryptPasswordEncoder encoder  =new BCryptPasswordEncoder(12);
	
	
	

	public UserDTO saveUser(UserDTO user) {

		System.out.println("saveUser method called");

		System.out.println(user.getAge());

		    User userEntity= entityDTOMapper.DtoToEntity(user,User.class);
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));

		    
		User userResponse=repo.save(userEntity);


		       if(userResponse!=null){
 
				return entityDTOMapper.EntityToDto(userResponse, UserDTO.class);

			   } else{
				return  null;

			   }
	
           

	}
	
	
	
	public  boolean      isEmailExist(UserDTO userDTO){
          
		
    // Fetch mobile number from userDTO
    String email = userDTO.getEmail();

    // Check if the mobile number exists in the database
    return repo.findByEmail(email).isPresent();
}


public boolean isMobileNumberExist(UserDTO userDTO) {

    // Fetch mobile number from userDTO
    String mobileNumber = userDTO.getMobileNumber();

    // Check if the mobile number exists in the database
    return repo.findByMobileNumber(mobileNumber).isPresent();
}


}