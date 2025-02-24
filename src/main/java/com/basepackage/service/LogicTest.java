package com.basepackage.service;

import java.util.List;

public class LogicTest {

	
 public    static List<String>   data = List.of("apple", "banana", "cherry", "apricot", "blueberry", "date");

	
     
     
	public static void main(String [] args) {
		
		
		System.out.println(getFruitsByName("Apple"));
		
		
		System.out.println(getFruitById(1L));
	}
	
	
	 public static  List<String>  getFruitsByName(String name){
		 
		              
		 if(name==null) {
			 
			 throw new IllegalArgumentException("name is not found");
		 }
		  
		 
		 return data.parallelStream().filter(word->{
			 
			 
			 return word.equalsIgnoreCase(name);
		 }).toList();
		
	 } 
	 
	 
	 public static   String getFruitById(Long id) {
		 
		 
		 String s= id.toString();
		 
		 String result="";
		 
		 if(id==null) {
			 throw new IllegalArgumentException("id not found");
		 }
	
		 
		 
		 if(id<0||id>=data.size()) {
			 
			 return  "invalid";
		 }
		 
		  Object [] a=data.toArray();
			 
	               
	
		 for(Object s3:a) {
			
			 System.out.println(s3);
			 Long i=0L;
			 
			 System.out.println(id);
			 if(id.equals(i)) {
				 
				 System.out.println((String) s3+" ::");
				  result=(String) s3;
			 }
			 i++;
            
			 System.out.println("i ?"+i);
			 System.out.println( result+" ?");
			 
		 }
		 
		 return result;
	 }
	 
	 
}