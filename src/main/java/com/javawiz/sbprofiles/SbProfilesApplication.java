package com.javawiz.sbprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SbProfilesApplication {

	@Autowired
	private WeatherService weatherService;

	public static void main(String[] args) {
		SpringApplication.run(SbProfilesApplication.class, args);
	}

	@Bean
	CommandLineRunner run(){
		return args -> {
			System.out.println(weatherService.forecast());
		};
	}
}
