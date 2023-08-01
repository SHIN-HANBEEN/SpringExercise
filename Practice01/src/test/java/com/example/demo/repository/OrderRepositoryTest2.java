package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest2 {
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void getOrder1() {
		LocalDateTime localDateTime = LocalDateTime.of(2023, 7, 3, 0, 0, 0);
		
		List<Order> list = orderRepository.getOrder1(localDateTime);
		for(Order order : list) {
			System.out.println(order);
		}
	}
}
