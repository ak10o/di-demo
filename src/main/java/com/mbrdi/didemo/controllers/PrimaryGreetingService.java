package com.mbrdi.didemo.controllers;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.mbrdi.didemo.services.GreetingService;

@Service
@Primary
// If we don't write the Profile then it will throw an error saying NoUniqueBeanDefinitionException
@Profile("en")
public class PrimaryGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Injected by PrimaryGreetingService";
	}

}
