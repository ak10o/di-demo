package com.mbrdi.didemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.mbrdi.didemo.externalization.FakeDataSource;

@Configuration
@PropertySource("datasource.properties")
public class PropertyConfiguration {

	@Autowired
	Environment env;
	
	@Value("${guru.username}")
	String user;
	
	@Value("${guru.password}")
	String password;
	
	@Value("${guru.dburl}")
	String url;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUserName(user);
		if (env.getProperty("pwd").isEmpty()) {
			fakeDataSource.setPassword(password);
		} else {
			fakeDataSource.setPassword(env.getProperty("pwd"));
		}
		fakeDataSource.setDburl(url);
		return fakeDataSource;
	}
}
