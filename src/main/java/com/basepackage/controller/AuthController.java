// package com.basepackage.controller;


// import java.sql.Time;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.LocalTime;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.cglib.core.Local;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.security.core.Authentication;
// import com.basepackage.model.User;
// import com.basepackage.service.UserService;
// import com.basepackage.util.JwtService;
// import com.nimbusds.oauth2.sdk.SuccessResponse;


// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

	
	
// 	@Autowired
// 	private AuthenticationManager authManager;
	
	
	
// 	@Autowired
// 	private JwtService jwtService;
	
	
// 	@Autowired
// 	private  UserService    userService;
	
	
// 	@PostMapping("/register")
// 	public  ResponseEntity<?>          register(@RequestBody 	User user) {
		
// 		if(user!=null) {
// 			 userService.saveUser(user);
// 			return ResponseEntity.status(HttpStatus.CREATED).body( new Object() {
				
// 					 public String  message="User  registered successfully";
// 					 public String  status="success";
					
					
// 			}  );
					
// 		} else {
// 			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
// 		  new Object() {
			  
// 			  public String  message="error registering the user ";
// 			  public String status="error";
// 		  }
// 		  );
// 		}

		 

		 
// 	}
	
	
// 	@PostMapping("/login")
// 	public String login(@RequestBody  User user) {
		
// Authentication  authentication    =authManager.authenticate(
// 				new  UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
// 				);
				
// 			return 	jwtService.generateToken(authentication.getName());
				
// 	}
	
	
// 	@GetMapping("/greet")
// 	public String  greet() {
		
		
// 		LocalTime currentTime= LocalDateTime.now().toLocalTime();
		
		
// 		if(currentTime.isBefore(LocalTime.NOON)) {
		
// 			return "Good mornig";
// 		} else if(currentTime. isBefore(LocalTime.of(18, 0))){
// 			return "Good evening";
// 		} else {
// 			return "Good night";
// 		}
		

  
// 	}
	
// }
