package com.basepackage.util;

import java.awt.RenderingHints.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	
	private final   SecretKey  key =Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	

	public String generateToken(String username) {
		
		return Jwts.builder().setSubject(username).setIssuedAt(new Date() ).
				setExpiration(new Date(System.currentTimeMillis()+1000*30*60)).
				signWith(key).compact();
	
	
	}
	
	
	public boolean validateToken(String token,UserDetails userDetails) {
		
		String username=extractUserName(token);
		
			return (username.equals(userDetails.getUsername()) &&!isTokenExpired(token));
			
			
	}


	public String extractUserName(String token) {

		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	
	}
	
	
	private boolean 	isTokenExpired(String token) {
		
		return extractExpiration(token).before(new Date());
	}


	private Date extractExpiration(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getExpiration();

	}
	
	
	
	
	
}
