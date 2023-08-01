package com.example.demo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftRepositoryTest {
	@Autowired
	GiftRepository giftRepository;
	
	@Test
	public void 데이터등록() {
		Gift gift1 = Gift.builder()
						 .name("참치세트")
						 .price(10000)
						 .type("식품")
						 .build();
		Gift gift2 = Gift.builder()
						 .name("햄세트")
						 .price(20000)
						 .type("식품")
						 .build();
		Gift gift3 = Gift.builder()
				 .name("샴푸세트")
				 .price(30000)
				 .type("생활용품")
				 .build();
		Gift gift4 = Gift.builder()
				 .name("세차용품")
				 .price(40000)
				 .type("생활용품")
				 .build();
		Gift gift5 = Gift.builder()
				 .name("주방용품")
				 .price(50000)
				 .type("생활용품")
				 .build();
		Gift gift6 = Gift.builder()
				 .name("노트북")
				 .price(60000)
				 .type("가전제품")
				 .build();
		Gift gift7 = Gift.builder()
				 .name("벽걸이")
				 .price(70000)
				 .type("가전제품")
				 .build();
		
		giftRepository.save(gift1);
		giftRepository.save(gift2);
		giftRepository.save(gift3);
		giftRepository.save(gift4);
		giftRepository.save(gift5);
		giftRepository.save(gift6);
		giftRepository.save(gift7);
	}
	
	@Test
	public void 데이터조회() {
		Optional<Gift> result = giftRepository.findById(1);
		if(result.isPresent()) {
			Gift gift = result.get();
			System.out.println(gift);
		}
	}
	
	@Test
	public void 데이터수정() {
		Gift gift = Gift.builder()
						.no(1)
						.name("참치세트")
						.price(10000)
						.type("수정되었습니다.")
						.build();
		giftRepository.save(gift);
	}
	
	@Test
	public void 데이터삭제() {
		giftRepository.deleteById(1);
	}
}
