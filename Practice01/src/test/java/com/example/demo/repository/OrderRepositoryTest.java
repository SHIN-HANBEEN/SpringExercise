package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {
	@Autowired
	OrderRepository orderRepository;
	
	@Test 
	public void 데이터등록() {
		LocalDateTime localDateTime1 = LocalDateTime.of(2023, 7, 1, 0, 0, 0);
		LocalDateTime localDateTime2 = LocalDateTime.of(2023, 7, 2, 0, 0, 0);
		LocalDateTime localDateTime3 = LocalDateTime.of(2023, 7, 3, 0, 0, 0);
		
		Order order1 = Order.builder()
							 .customerName("둘리")
							 .shipAddress("인천 구월동")
							 .orderDate(localDateTime1)
							 .build();
		orderRepository.save(order1);
		
		Order order2 = Order.builder()
				 .customerName("또치")
				 .shipAddress("인천 연수동")
				 .orderDate(localDateTime2)
				 .build();
		orderRepository.save(order2);
		
		Order order3 = Order.builder()
				 .customerName("도우너")
				 .shipAddress("부산 동래동")
				 .orderDate(localDateTime3)
				 .build();
		orderRepository.save(order3);
	}
	
	@Test
	public void 데이터조회() {
		Optional<Order> order = orderRepository.findById(1);
		if(order.isPresent()) {
			System.out.println(order.get());
		}
	}
	
	@Test
	public void 데이터삭제() {
		orderRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		orderRepository.deleteAll();
	}
}
