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
	
	@Test
	public void 회원등록() {
		Member member = new Member("user1","1234","둘리");
		repository.save(member);
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
		repository.deleteAll(); //게시물 테이블에서 참조하고 있으면 회원을 삭제할 수 없음
	}

}

