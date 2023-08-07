package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/*
* @CreatedDate @LastModifiedDate @EntityListeners 를 제공하는 Auditing 기능을 활성화
 * */
@SpringBootApplication
@EnableJpaAuditing
public class Project06Application {

	public static void main(String[] args) {
		SpringApplication.run(Project06Application.class, args);
	}

}
