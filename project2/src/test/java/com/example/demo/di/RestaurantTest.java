package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestaurantTest {
	
	@Autowired
	Restaurant restaurant;
	
	@Autowired
	Chef chef;
	
	@Autowired
	Chef chef2;
	
	@Test
	void Test() {
		System.out.println("restaurant: " + restaurant);
		System.out.println("chef: " + chef);
		System.out.println("getChef(): " + restaurant.getChef());

	}
}
