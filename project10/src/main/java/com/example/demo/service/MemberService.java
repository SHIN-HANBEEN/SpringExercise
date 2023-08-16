package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;

public interface MemberService {
	Page<MemberDTO> getList(int page); // 회원 목록조회 추상메서드 추가
	
	// 엔티티를 DTO로 변환하는 메소드 추가
	default MemberDTO entityToDto(Member entity) {
		MemberDTO dto = MemberDTO.builder().id(entity.getId())
				.password(entity.getPassword())
				.name(entity.getName())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.role(entity.getRole()) // 새롭게 추가한 회원 등급 추가해주기
				.build();
		
		return dto;
	}
	
	boolean register(MemberDTO dto); // 회원 등록 추상메서드 추가
	// 항상 회원 등록이 성공하는 것은 아니다. 
	
	// DTO 를 엔티티로 변환하는 메소드 추가
	default Member dtoToEntity(MemberDTO dto) {
		Member entity = Member.builder()
				.id(dto.getId())
				.password(dto.getPassword())
				.name(dto.getName())
				.role(dto.getRole()) //새롭게 추가한 회원 등급 추가해주기
				.build();
		return entity;
	}
	
	// 회원 상세페이지 조회(단건 조회) 추상 메서드 추가
	MemberDTO read(String id);

	boolean registerList(List<MemberDTO> list);
}
