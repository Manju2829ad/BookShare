package com.basepackage.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.basepackage.model.Book;
import com.basepackage.repo.BookRepo;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.config.ExecutorBeanDefinitionParser;



@Service
public class BookService {

	
	@Autowired
	BookRepo bookRepo;
	

	public   List<Book> getBooksByCategory(String categoryName, int pageNumber,int size){
		
		
		System.out.println(categoryName);
		System.out.println(pageNumber);
		System.out.println(size);
		
		
		//pageable class defines no of pages and size 
		//PageRequest.of(pageNumber, pageSize): Helps create pageable queries.
	
		Pageable pageable=  PageRequest.of(pageNumber-1, size);
		
	
		     Page<Book> books= bookRepo.findByCategory(categoryName, pageable);

		            System.out.println(" content : "+books.getContent());
		            
		        return books.getContent();  // Extract list from Page

	
	}
	
	public Optional<Book> getBookById(Long id) {
	    if (id == null || id <= 0) {
	        throw new IllegalArgumentException("Invalid Book Id");
	    }
	     return bookRepo.findById(id);
	}
	
	
	
	public List<Book> searchBookByTitle(String title,int pageNumber,int size){
	
		Pageable pageable= PageRequest.of(pageNumber, size);
		
		Page<Book> books=bookRepo.findByTitle(title, pageable);
		
		           System.out.println("books ? "+books);
		return  books.getContent();
		
		
	}
	
}
