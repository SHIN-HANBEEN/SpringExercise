package com.example.demo.service;

import com.example.demo.entity.Member;
import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

public interface BoardService {

	int register(BoardDTO dto);

	Page<BoardDTO> getList(int pageNumber);

	BoardDTO read(int no);

	void modify(BoardDTO dto);

	void remove(int no);

	default Board dtoToEntity(BoardDTO dto) {
		Member member = Member.builder().id(dto.getWriter()).build();

		Board entity = Board.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(member) //값 변경
				.build();
		return entity;
	}

	/* 작성자 필드 수정 */
	default BoardDTO entityToDto(Board entity) {
		BoardDTO dto = BoardDTO.builder()
				.no(entity.getNo())
				.title(entity.getTitle())
				.content(entity.getContent())
				.writer(entity.getWriter().getId())
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();

		return dto;
	}

}
