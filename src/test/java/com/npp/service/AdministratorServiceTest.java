package com.npp.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.npp.NppBackEndApplication;
import com.npp.entity.Administrator;
import com.npp.iservice.IAdministratorService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NppBackEndApplication.class)
public class AdministratorServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdministratorService.class);

	@Autowired
	IAdministratorService adminservice;

	@Test
	public void addAdministrator() {
		String name = "guillaume";
		LOGGER.info("----------- Testing addAdministrator Method ----------");
		LOGGER.info("----------- Creation of an administrator ----------");
		Administrator admin = new Administrator();
		admin.setName(name);
		LOGGER.info("----------- Insert in the database ----------");
		Administrator addedAdministrator = adminservice.add(admin);
		LOGGER.info("----------- Recuperation of the administrator ----------");
		List<Administrator> aListFound = adminservice.findByName(name);
		LOGGER.info("----------- Test of the table lenght ----------");
		assertEquals(1, aListFound.size());
		LOGGER.info("----------- Test of the compatibility between name ----------");
		assertEquals(name, addedAdministrator.getName());

	}
	

}
