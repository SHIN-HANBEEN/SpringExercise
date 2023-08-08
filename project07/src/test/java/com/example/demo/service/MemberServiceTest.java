package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@SpringBootTest
public class MemberServiceTest {
	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void 회원목록조회() {
		Page<MemberDTO> page = memberService.getList(0);
		// dtopage 를 가져온다. 
		
		List<MemberDTO> list = page.getContent();
		// dtoPage 의 getContent 메서드를 활용해서 List 로 값을 가져온다.
		
		for (MemberDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test 
	public void 회원일괄등록() {
		List<Member> list = new ArrayList<>();
		for (int i=1; i<=30; i++) {
			if (i < 10) {
				list.add(new Member("user0" + i, "1234", "둘리"));
			} else {
				list.add(new Member("user" + i, "1234", "둘리"));
			}
		}
		memberRepository.saveAll(list);
	}
}
