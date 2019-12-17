package com.mbrdi.didemo.controllers;

import com.mbrdi.didemo.services.GreetingService;

public class ConstructorInjectedController {

	private GreetingService greetingService;

	public ConstructorInjectedController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
}
