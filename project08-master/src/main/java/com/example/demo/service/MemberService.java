package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import org.springframework.data.domain.Page;

public interface MemberService {
	
	Page<MemberDTO> getList(int pageNumber);
	
	boolean register(MemberDTO dto);

	MemberDTO read(String id);

	default MemberDTO entityToDto(Member entity) {
		MemberDTO dto = MemberDTO.builder()
				.id(entity.getId())
				.password(entity.getPassword())
				.name(entity.getName())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.role(entity.getRole()) //등급 추가
				.build();

		return dto;
	}

	default Member dtoToEntity(MemberDTO dto) {
		Member entity = Member.builder()
				.id(dto.getId())
				.password(dto.getPassword())
				.name(dto.getName())
				.role(dto.getRole()) //등급 추가
				.build();
		return entity;
	}

}
