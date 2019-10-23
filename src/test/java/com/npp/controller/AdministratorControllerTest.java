package com.npp.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.npp.NppBackEndApplication;
import com.npp.entity.Administrator;
import com.npp.iservice.IAdministratorService;
import com.npp.service.AdministratorService;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NppBackEndApplication.class)
public class AdministratorControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdministratorService.class);

	protected MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@InjectMocks
	private AdministratorController adminController;
	@Mock
	private IAdministratorService adminServiceToMock;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		MockitoAnnotations.initMocks(this);
	}

	protected String uri;

	public AdministratorControllerTest() {
		super();
		this.uri = "/administrator";
	}

	@Test
	public void addAdministrator() {
		LOGGER.info("----------- Testing addAdministrator Method ----------");
		LOGGER.info("----------- Create an administrator ----------");
		String name = "guillaume";
		Administrator admin = new Administrator();
		admin.setName(name);

		try {
			LOGGER.info("----------- Serializing utilisateur Object ----------");
			String inputJson = this.mapToJson(admin);
			LOGGER.info("---------- Mocking Context Webservice and invoking the webservice ----------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/add")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			LOGGER.info("---------- Getting HTTP Status ----------");
			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("---------- Verifying HTTP Status ----------");
			assertEquals(200, status);
			LOGGER.info("--------------- Verify the compatibility of the add with the mock controller ---------------");
			adminController.add(admin);
			verify(adminServiceToMock).add(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void update_when_no_administrator() {
		LOGGER.info("----------- Testing update_when_no_administrator Method ----------");
		LOGGER.info("----------- Create an administrator ----------");
		String name = "guillaume";
		Administrator admin = new Administrator();
		admin.setName(name);
		admin.setId(50L);

		try {
			LOGGER.info("----------- Test that the fonction is called correctly ----------");
			adminController.update(admin);
			verify(adminServiceToMock).update(admin, 50L);

			LOGGER.info("----------- Serializing utilisateur Object ----------");
			String inputJson = this.mapToJson(admin);
			LOGGER.info("---------- Mocking Context Webservice and invoking the webservice ----------");
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/update")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			LOGGER.info("---------- Getting HTTP Status ----------");
			int status = mvcResult.getResponse().getStatus();
			LOGGER.info("---------- Verifying HTTP Status ----------");
			assertEquals(404, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected final String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

}
