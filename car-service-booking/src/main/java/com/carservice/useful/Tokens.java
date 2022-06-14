package com.carservice.useful;

import java.util.UUID;

public class Tokens {
	
	private Tokens() {}
	
	public static String tokenGenerate() { 
	    UUID randomUUID = UUID.randomUUID(); 
	    return randomUUID.toString().replace("-", ""); 
	  } 

}
