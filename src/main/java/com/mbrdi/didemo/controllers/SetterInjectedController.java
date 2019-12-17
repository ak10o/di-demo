package com.mbrdi.didemo.controllers;

import com.mbrdi.didemo.services.GreetingService;

public class SetterInjectedController{

	private GreetingService greetingService;

	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
	
}
