package com.mbrdi.didemo.controllers;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mbrdi.didemo.services.GreetingService;

@Service
@Primary
public class PrimaryGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Injected by PrimaryGreetingService";
	}

}
