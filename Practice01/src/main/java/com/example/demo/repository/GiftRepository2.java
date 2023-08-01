package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;
import com.example.demo.entity.Gift;

public interface GiftRepository2 extends JpaRepository<Book, Integer>{
	// 가격이 5만원 이상인 선물 검색
	// JPQL 을 사용할 때는 DB의 테이블명을 사용하는 것이 아니라 
	// Entity 명을 사용해야 한다.
	// SELECT * FROM tbl_gift WHERE price >= 50000;
	@Query("SELECT g FROM Gift g WHERE g.price >= :price")
	List<Gift> getGift1(@Param("price") int price);
	
	
	// 이름이 '세트'로 끝나는 선물 검색
	// SELECT * FROM tbl_gift where name like '%세트';
	@Query("SELECT g FROM Gift g WHERE g.name like :name")
	List<Gift> getGift2(@Param("name") String name);
	
	// 가격은 40000원 이하이고 품목은 생활용품인 선물 검색
	// SELECT * FROM tbl_gift where price <= 40000 and type = '생활용품';
	@Query("SELECT g FROM Gift g WHERE g.price <= :price and g.type = :type")
	List<Gift> getGift3(@Param("price") int price, @Param("type") String type);
}

