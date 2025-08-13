package com.AliceAndHerBackery.HomeWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeWorkApplication implements CommandLineRunner {

	@Autowired
	CakeBaker cakeBaker;
	public static void main(String[] args) {
		SpringApplication.run(HomeWorkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cakeBaker.bakeCake();
	}
}
