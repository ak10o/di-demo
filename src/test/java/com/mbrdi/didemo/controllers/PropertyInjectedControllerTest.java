package com.mbrdi.didemo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mbrdi.didemo.services.GreetingServiceImpl;

public class PropertyInjectedControllerTest {

	private PropertyInjectedController propertyInjectedController;
	
	@BeforeEach
	public void setup() {
		this.propertyInjectedController = new PropertyInjectedController();
		this.propertyInjectedController.greetingServiceImpl = new GreetingServiceImpl();
	}
	
	@Test
	public void testGreeting() {
		assertEquals("Hello Gurus!!",propertyInjectedController.sayHello());
	}
}
