package com.mbrdi.didemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mbrdi.didemo.services.GreetingService;

//@Controller is used to specify that this class will be managed by Spring as a bean 
@Controller
public class ConstructorInjectedController {

	private GreetingService greetingService;

	// this is used to ask the spring to inject the appropriate instance at runtime
	@Autowired
	public ConstructorInjectedController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
}
