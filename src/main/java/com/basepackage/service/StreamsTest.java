package com.basepackage.service;

import java.util.List;

public class StreamsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<String>  data=List.of("Banana","BApple","BOrange","Gauva");
		
		
          
		data.stream().filter(word->{
			 
			System.out.println("filtering word :"+word);
			
			return word.startsWith("B");
		}).map(word->{
			
			System.out.println("filtering the word:"+word);
			return word.toLowerCase();
		});
	}

}
