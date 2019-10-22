package com.npp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.npp.entity.Administrator;
import com.npp.iservice.IGenericUserService;

@SpringBootApplication
public class NppBackEndApplication implements CommandLineRunner {

	@Autowired
	IGenericUserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(NppBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Administrator a = new Administrator();
		a.setEmail("toto@titi.com");
		a.setName("titi");
		
//		userService.add(a);
	}

}
