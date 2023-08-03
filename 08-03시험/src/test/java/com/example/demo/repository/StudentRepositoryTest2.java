package com.example.demo.repository;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class StudentRepositoryTest2 {

	@Autowired
	StudentRepository2 studentRepository2;
	
	@Test
	public void 테스트() {
		System.out.println(studentRepository2.getIncheon());
		System.out.println(studentRepository2.getByGrade(1, 3));
	}
	
}
