package com.mbrdi.didemo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mbrdi.didemo.services.GreetingServiceImpl;

public class SetterInjectedControllerTest {

private SetterInjectedController setterInjectedController;
	
	@BeforeEach
	public void setup() {
		this.setterInjectedController = new SetterInjectedController();
		this.setterInjectedController.setGreetingService(new GreetingServiceImpl());
	}
	
	@Test
	public void testGreeting() {
		assertEquals("Hello Gurus!!",setterInjectedController.sayHello());
	}

}
