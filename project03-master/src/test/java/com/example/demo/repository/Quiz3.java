package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.entity.Order;

/*
 * Order엔티티클래스와 OrderReposiotry인터페이스를 이용하여 다음과 같이 테이블을 만드세요.
 * 다음과 같이 테이블에 데이터를 추가하세요.
 * 그리고 테이블에 데이터를 조회, 수정, 삭제 하세요.
 * */
@SpringBootTest
public class Quiz3 {
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void 데이터등록() {
		Order order1 = new Order(0,"둘리","인천 구월동",null);
		orderRepository.save(order1);
		Order order2 = new Order(0,"또치","부산 동래동",null);
		orderRepository.save(order2);
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Order> result = orderRepository.findById(1);
		if(result.isPresent()) {
			Order order = result.get();
			System.out.println(order);
		}
	}
	@Test
	public void 데이터전체조회() {
		List<Order> list = orderRepository.findAll();
		for(Order order : list) {
			System.out.println(order);
		}
	}
	
	@Test
	public void 데이터수정() {
		Optional<Order> result = orderRepository.findById(1);
		Order order = result.get();
		order.setShipAddress("서울 신림동");
		orderRepository.save(order);
	}
	
	@Test
	public void 데이터삭제() {
		orderRepository.deleteById(1);
	}

}
