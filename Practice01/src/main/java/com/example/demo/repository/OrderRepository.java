package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	// SELECT * FROM tbl_order where order_date = '2023-07-03';
	// 매개변수로 어떤 자료변수를 받아올지 고민이 될 수 있는데, 간단하다.
	// 엔티티에 가서 실제로 어떤 자료형인지 보면 된다. LocalDateTime 임을 확인했다.
	@Query("SELECT o From Order o where orderDate = :date")
	List<Order> getOrder1(@Param("date") LocalDateTime date);
	
}

