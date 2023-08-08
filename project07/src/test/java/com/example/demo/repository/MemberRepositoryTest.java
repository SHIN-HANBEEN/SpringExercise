package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {
	@Autowired
	MemberRepository repository;
	
	@Autowired
	BoardRepository boardRepository;
	// 원래는 위 처럼 다른 리포지토리를 갖고오는 것은 권장되지 않는다
	// 왜냐하면 단위 테스트의 기본 목적이 훼손되기 때문이다.
	
	@Test 
	public void 연관관계설정후_회원삭제() {
		// 게시물이 없는 회원은 삭제해도 문제가 없지만, 게시물이 있는 경우에는 삭제할 수 없음
		// 회원을 삭제하려면 회원일 참조하는 게시물을 먼저 삭제해야함
		Member member = Member.builder().id("user1").build();
		boardRepository.deleteWriter(member);
		repository.deleteById("user1");
	}
	
	
	@Test
	public void 회원등록() {
		for (int i = 1; i < 4; i++) {
			Member member = new Member("user" + i,"1234","둘리");
			repository.save(member);
		}
		
	}

	@Test
	public void 회원목록조회() {
		List<Member> list = repository.findAll();
		for(Member member : list) {
			System.out.println(member);
		}
	}

	@Test
	public void 회원단건조회() {
		Optional<Member> result = repository.findById("user1");
		if(result.isPresent()) {
			Member member = result.get();
			System.out.println(member);
		}
	}

	@Test
	public void 회원수정() {
		Optional<Member> result = repository.findById("user1");
		Member member = result.get();
		member.setName("또치");
		repository.save(member);	
	}
	
	@Test
	public void 회원삭제() {
		repository.deleteById("user1");
	}

	@Test
	public void 모든회원삭제() {
		boardRepository.deleteAll(); // 참조 관계를 가지고 있는 Board 를 먼저 삭제하고 member
		// 를 삭제해야 한다. 
		repository.deleteAll(); //게시물 테이블에서 참조하고 있으면 회원을 삭제할 수 없음
	}

}

