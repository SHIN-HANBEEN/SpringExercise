package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftRepositoryTest2 {
	@Autowired
	GiftRepository2 giftRepository;
	
	@Test
	public void getGift1() {
		List<Gift> list = giftRepository.getGift1(50000);
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void getGift2() {
		List<Gift> list = giftRepository.getGift2("%세트");
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void getGift3() {
		List<Gift> list = giftRepository.getGift3(40000,"생활용품");
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
}
