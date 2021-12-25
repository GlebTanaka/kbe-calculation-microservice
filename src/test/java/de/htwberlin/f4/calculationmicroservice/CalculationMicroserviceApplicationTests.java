package de.htwberlin.f4.calculationmicroservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.htwberlin.f4.calculationmicroservice.controllers.CalculateMehrwertsteuerController;
import de.htwberlin.f4.calculationmicroservice.services.CalculateMehrwertsteuerService;

@SpringBootTest
class CalculationMicroserviceApplicationTests {

	@Autowired
	private CalculateMehrwertsteuerController controller;
	@Autowired
	private CalculateMehrwertsteuerService service;

	@Test
	void contextLoads() {
		assertNotNull(controller);
		assertNotNull(service);
	}

}
