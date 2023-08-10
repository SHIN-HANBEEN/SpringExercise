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
	
	@Autowired
	MemberService service;
	
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
		List<MemberDTO> listDto = new ArrayList<>();
		
		for (int i=1; i<=30; i++) {
			if (i < 10) {
				list.add(new Member("user0" + i, "1234", "둘리", "일반회원"));
			} else {
				list.add(new Member("user" + i, "1234", "둘리", "일반회원"));
			}
		}
		
		for (Member member : list) {
			MemberDTO memberDTO = service.entityToDto(member);
			listDto.add(memberDTO);
		};
		
		service.registerList(listDto);
	}
	
	@Test
	public void 회원등록() {
		MemberDTO dto = MemberDTO.builder()
				.id("duli")
				.password("duliPassword")
				.name("둘리") 
				.build();
		
		boolean isSuccess = service.register(dto);
		
		if(isSuccess) {
			System.out.println("회원이 등록되었습니다.");
		} else {
			System.out.println("중복된 회원 입니다.");
		}
	}
	
	@Test 
	public void 특정회원정보조회() {
		String id = "user01";
		MemberDTO memberDTO = service.read(id);
		System.out.println(memberDTO);			
	}
}
