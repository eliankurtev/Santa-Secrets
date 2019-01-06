package com.nbu.secretsanta.secretsanta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SecretsantaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecretsantaApplication.class, args);
	}
}
