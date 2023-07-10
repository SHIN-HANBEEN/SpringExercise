package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

public interface GiftRepository2 extends JpaRepository<Gift, Integer> {

	// select * from gift where price >= 50000
	@Query("select m from Gift m where m.price >=:price")
	List<Gift> get1(@Param("price") int price);

	// SELECT * FROM GIFT WHERE NAME LIKE '%세트';
	@Query("select m from Gift m where m.name like %:name")
	List<Gift> get2(@Param("name") String name);
	
	// select * from gift where price <= 40000 and type = 생활용품 
	@Query("select m from Gift m where m.price <= :price and type=:type")
	List<Gift> get3(@Param("price") int price, @Param("type") String type);

}
