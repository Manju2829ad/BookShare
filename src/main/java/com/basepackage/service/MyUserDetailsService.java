package com.basepackage.service;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.basepackage.model.User;
import com.basepackage.model.UserPrincipal;
import com.basepackage.repo.UserRepo;


@Repository
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	


	@Override
	public UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException {

	User user= repo.findByEmail(gmail).orElse(null);
	
	if (user==null) {
		System.out.println("User 404");
		throw new UsernameNotFoundException("User 404");
	}
		 return new UserPrincipal(user);
	}

}
