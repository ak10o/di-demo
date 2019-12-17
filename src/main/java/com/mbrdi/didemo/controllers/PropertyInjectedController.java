package com.mbrdi.didemo.controllers;

import com.mbrdi.didemo.services.GreetingServiceImpl;

public class PropertyInjectedController {

	public GreetingServiceImpl greetingServiceImpl;
	
	public String sayHello() {
		return greetingServiceImpl.sayGreeting();
	}
}
