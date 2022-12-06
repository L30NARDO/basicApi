package com.dev.basicapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableJpaRepositories
@SpringBootApplication
public class BasicApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApiApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
