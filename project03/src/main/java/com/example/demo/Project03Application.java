package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // 추가 
@SpringBootApplication
public class Project03Application {

	public static void main(String[] args) {
		SpringApplication.run(Project03Application.class, args);
	}

}
