package com.basepackage.service;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

public class Streamtest3 {

	
	public static void main(String [] args) {
		
		
        List<String> data = List.of("apple", "banana", "cherry", "apricot", "blueberry", "date");
		
		
                     var stream= data.parallelStream();
                     
                     
                     stream.forEach(word->{
                    	 
                    	 System.out.println("name: "+Thread.currentThread().getName()+" :"+word);
                     });
}

	
}