package com.npp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

//		StandardUser a = (StandardUser) userService.findByEmail("totu@titi.com");
////		a.setEmail("totu@titi.com");
//		a.setName("titi");
//		a.setPassword("baaa");
//
//		userService.update(a);
	}

}
