package com.npp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.npp.embedded.Localisation;
import com.npp.entity.GenericStation;
import com.npp.entity.GenericUser;
import com.npp.entity.NormalStation;
import com.npp.entity.PowerBank;
import com.npp.entity.StandardUser;
import com.npp.entity.Subscription;
import com.npp.enumerator.SubscriptionType;
import com.npp.iservice.IGenericStationService;
import com.npp.iservice.IGenericUserService;
import com.npp.iservice.IPowerBankService;
import com.npp.iservice.ISubscriptionService;

@SpringBootApplication
public class NppBackEndApplication implements CommandLineRunner{

	@Autowired
	IPowerBankService pbService;
	
	@Autowired
	IGenericStationService sService;
	
	@Autowired
	IGenericUserService userService;
	
	@Autowired
	ISubscriptionService subService;
	
	public static void main(String[] args) {
		SpringApplication.run(NppBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

////		PowerBank p1 = new PowerBank();
////		p1.setLevel(0.1);
//		PowerBank p2 = new PowerBank();
//		p2.setLevel(0.5);
////		
//		GenericStation s1 = new NormalStation();
//		s1.setLocalisation(new Localisation(5d, 45d));
//		
//		s1 = sService.add(s1);
////		
////		p1.setGenericStation(s1);
//		p2.setGenericStation(s1);
//		
////		pbService.add(p1);
//		pbService.add(p2);
		
		
//		PowerBank p3 = new PowerBank();
//		p3.setLevel(0.5);
//		PowerBank p4 = new PowerBank();
//		p4.setLevel(0.7);
//		
//		GenericStation s2 = new NormalStation();
//		s2.setLocalisation(new Localisation(5d, 45.3d));
//		
//		s2 = sService.add(s2);
//		
//		p3.setGenericStation(s2);
//		p4.setGenericStation(s2);
//		
//		pbService.add(p3);
//		pbService.add(p4);
		
		Subscription s1 = new Subscription();
		
		GenericUser p1 = new StandardUser();
		
		p1.setName("guillaume");
		p1 = userService.add(p1);
		
		s1.setGenericUser(p1);
		
		
		SubscriptionType sub1 = SubscriptionType.basic ;
		s1.setType(sub1);
		
		subService.add(s1);
	}

}
