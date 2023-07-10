package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;
import com.example.demo.entity.Memo;

@SpringBootTest
public class Quiz5 {

	@Autowired
	GiftRepository2 giftRepository2;
	
	@Test
	public void 가격이5만원이하인_선물검색() {
		List<Gift> list = giftRepository2.get1(50000);
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 이름이세트로끝나는_선물검색() {
		List<Gift> list = giftRepository2.get2("세트");
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void 가격은4만원이하고품목은생활용품인_선물검색() {
		List<Gift> list = giftRepository2.get3(40000,"생활용품");
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
}
