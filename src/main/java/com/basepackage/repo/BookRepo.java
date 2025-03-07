package com.basepackage.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basepackage.model.*;

@Repository
public interface BookRepo     extends JpaRepository<Book, Long> {


	
	        //Default JPA Method to find  a book by id
	Optional<Book> findById(Long id);
	
	
	//Custom method for finding books by category
	
	Page<Book> findByCategory(String categoryName,Pageable pageable);
	
	
	
	Page<Book>  findByTitle(String title,Pageable pageable);
	

	
	
	
	

}
