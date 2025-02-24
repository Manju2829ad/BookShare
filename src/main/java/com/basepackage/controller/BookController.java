package com.basepackage.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basepackage.model.Book;
import com.basepackage.service.BookService;

import jakarta.servlet.http.HttpServletRequest;

@RestController

@RequestMapping("/api/auth/books")
public class BookController {

	
	@Autowired
	BookService  bookService;
	/*
	 * 
	 * 
	 * StringBuilder errorMessage = new StringBuilder();

if (category == null) {
    errorMessage.append("Category cannot be null. ");
}
if (pageNumber < 0) {
    errorMessage.append("Page number must be 0 or greater. ");
}
if (pageSize <= 0) {
    errorMessage.append("Page size must be greater than 0.");
}

if (errorMessage.length() > 0) {
    return ResponseEntity.badRequest().body(errorMessage.toString().trim());
}

	 */
	
	
	public ResponseEntity<String> serviceCallResult(){
		
		return ResponseEntity.ok("Service call was successfull");
	}
	
	@GetMapping("category")
	public ResponseEntity<?>  	 getBooksByCategory( @RequestParam String category,int pageNumber, int pageSize){
		
		
		System.out.println("category :"+category);
		StringBuilder errorMessage = new StringBuilder();
		
		if(category==null){
			errorMessage.append("Category cannot be null");
			
		}
		
		if(errorMessage.length()>0) {
			return ResponseEntity.badRequest().body(errorMessage.toString().trim());
					
		}
		
		
List<String > errors = Stream.of(pageSize<0?"page size must be greater than zero ":null).filter(Objects::nonNull).collect(Collectors.toList());
		
		if(!errors.isEmpty()) {
			
			ResponseEntity.badRequest().body(errors);
			
		}
		 
		List<Book> books =bookService.getBooksByCategory(category, pageNumber, pageSize);
		
		      
		        System.out.println(books);
		        
		
		return ResponseEntity.ok(books);
		
		
//		String errorMessage2 =  pageNumber<0?"page number cannot be less than zero ":" ";
//		
//		return    errorMessage2.isEmpty()? serviceCallResult() :ResponseEntity.badRequest().body(errorMessage);
//		
		

		
		
		
		
	}
	
}
