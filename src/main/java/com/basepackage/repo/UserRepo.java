package com.basepackage.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basepackage.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	// User findByUsername(String username);
	
	Optional<User> findByEmail(String email);


	Optional<User>  findByMobileNumber(String mobileNumber);
}
