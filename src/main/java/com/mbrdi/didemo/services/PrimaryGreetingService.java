package com.mbrdi.didemo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
// If we don't write the Profile then it will throw an error saying NoUniqueBeanDefinitionException
@Profile({"en","default"})
public class PrimaryGreetingService implements GreetingService {

	private GreetingRepository greetingRepository;
	
	public PrimaryGreetingService(GreetingRepository greetingRepository) {
		super();
		this.greetingRepository = greetingRepository;
	}

	@Override
	public String sayGreeting() {
		return greetingRepository.getEnglishGreeting();
	}

}
