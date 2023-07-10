package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CatTest {
	@Autowired
	Cat cat;
	
	@Test
	void test() {
		cat.eat();
	}
}
