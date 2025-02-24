package com.basepackage.model;

import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="available_books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="book_id")
	private Long id;
	
	
	@Column(name="book_name")
	private String book_name;
	
	
	@Column (name="book_title")
	
	private String    title;
	
	@Column(name="book_category")
	private String  category;
	
	@Column (name="no_of_pages")
	private  int pages;
	
	
	
	 public Book() {
		 
		 
	 }
	
	 public Book(String book_name,String category,int pages,String title) {
	
		 this.book_name=book_name;
		 this.category=category;
		 this.pages=pages;
		 this.title=title;
	 }

	public Long getId() {
		return id;
	}



	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", book_name=" + book_name + ", category=" + category + ", pages=" + pages + "]";
	}
	 
	 

	 
	
}
