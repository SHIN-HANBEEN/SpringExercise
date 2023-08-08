package com.example.demo.service;

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
				.build();
		
		return dto;
	}
}
