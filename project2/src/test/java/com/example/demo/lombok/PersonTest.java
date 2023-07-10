package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 단위테스트 환경 설정
public class PersonTest {
	
	@Test // 단위 테스트 지정
	void test() {
		Person person1 = new Person(); // 디폴트 생성자
		person1.setName("둘리"); // setter
		person1.setAge(12);
		System.out.println(person1.getName()); // getter
		System.out.println(person1.getAge());
		
		Person person2 = new Person("또치", 15); // 모든 멤버를 입력받는 생성자
		System.out.println(person2.toString()); // 재정의된 toString
	}
}
