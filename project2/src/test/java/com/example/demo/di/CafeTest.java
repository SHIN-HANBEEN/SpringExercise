package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CafeTest {
	@Autowired
	Cafe cafe;
	
	@Test
	void test() {
		System.out.println(cafe.manager);
	}
}
