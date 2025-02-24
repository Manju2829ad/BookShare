package com.basepackage.service;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Hashtable<String,Long> ht=new Hashtable();
		
		ht.put("Manjunaht", 5879855455L);
		ht.put("Ravai", 5879855455L);
		ht.put("Buridid", 8687544552L);
		
		
		
		      
		            Enumeration e= ht.elements();
		            
		             while(e.hasMoreElements()) {
		            	 
		            	 System.out.println(e.nextElement());
		            	 
		            	 
		            	 
		            	 
		            	 
		            	 
		            	 
		             }
		
		
		
	}

}
