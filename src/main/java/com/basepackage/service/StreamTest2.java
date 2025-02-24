package com.basepackage.service;

import java.util.List;

import java.util.stream.Collectors;

public class StreamTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> data =List.of("Banana","Orange","beetroot");
		
		 List<String> upperCaseWords = data.stream()
	                .map(String::toUpperCase)
	                .toList(); // No need for Collectors.toList()

System.out.println("data: " +data);


System.out.println(upperCaseWords);
		  
		
	}

}
