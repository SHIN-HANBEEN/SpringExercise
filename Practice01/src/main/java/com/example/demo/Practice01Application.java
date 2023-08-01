package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.EntityListeners;

@EnableJpaAuditing
// 날짜와 관련된 어노테이션을 사용할 수 있게 해줍니다.
// @EntityListeners(AuditingEntityListener.class) 이거와 세트로 꼭 사용해야 한다. 
@SpringBootApplication
public class Practice01Application {
	public static void main(String[] args) {
		SpringApplication.run(Practice01Application.class, args);
	}
}
