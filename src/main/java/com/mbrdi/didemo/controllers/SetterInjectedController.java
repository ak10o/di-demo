package com.mbrdi.didemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mbrdi.didemo.services.GreetingService;

@Controller
public class SetterInjectedController{

	private GreetingService greetingService;

	@Autowired
	public void setGreetingService( GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
	
}