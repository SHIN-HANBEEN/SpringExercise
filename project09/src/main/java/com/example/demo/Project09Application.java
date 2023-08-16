package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA의 날짜 관련 기능 활성화 합니다.
// 이 어노테이션이 없으면 날짜 관련 작업을 해줄 수 없습니다.
// 예를 들어 게시판에 등록 일자를 넣어줬는데 DB에는 적용이 되지 않게 됩니다. 
@SpringBootApplication
public class Project09Application {

	public static void main(String[] args) {
		SpringApplication.run(Project09Application.class, args);
	}

}
