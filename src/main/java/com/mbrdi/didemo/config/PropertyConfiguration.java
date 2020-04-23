package com.mbrdi.didemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.mbrdi.didemo.externalization.FakeDataSource;
import com.mbrdi.didemo.externalization.FakeJmsBroker;

@Configuration
@PropertySources({
	@PropertySource("datasource.properties"),
	@PropertySource("jms.properties")
})

public class PropertyConfiguration {

	@Autowired
	Environment env;
	
	@Value("${guru.username}")
	String user;
	
	@Value("${guru.password}")
	String password;
	
	@Value("${guru.dburl}")
	String url;
	
	@Value("${guru.jms.username}")
	String jmsUser;
	
	@Value("${guru.jms.password}")
	String jmsPassword;
	
	@Value("${guru.jms.url}")
	String jmsUrl;
	
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
	
	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUserName(jmsUser);
		fakeJmsBroker.setPassword(jmsPassword);
		fakeJmsBroker.setDburl(jmsUrl);
		return fakeJmsBroker;
	}

}
