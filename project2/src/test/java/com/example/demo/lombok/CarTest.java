package com.example.demo.lombok;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarTest {
	@Test
	public void test() {
		Car car1 = new Car();
		car1.setModelName("아반떼 cn7 하이브리드");
		car1.setCompany("현대");
		car1.setColor("grey Silver");
		System.out.println(car1.toString());
	}
}
