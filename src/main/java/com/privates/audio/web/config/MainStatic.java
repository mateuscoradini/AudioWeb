package com.privates.audio.web.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainStatic {
	
	
	public static void main(String[] args){
		
		BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
		String admin = "admin";
		
		System.out.println(enconder.encode(admin).toString());
	}

}
