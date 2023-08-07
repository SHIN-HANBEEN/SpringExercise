package com.example.demo.service;

import com.example.demo.entity.Member;
import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

public interface BoardService {

	int register(BoardDTO dto);

	/* 목록조회 메소드의 매개변수와 리턴타입 변경하기 */
	Page<BoardDTO> getList(int pageNumber);
//	List<BoardDTO> getList();

	BoardDTO read(int no);

	void modify(BoardDTO dto);

	void remove(int no);

	/* 작성자 필드 수정 */
	default Board dtoToEntity(BoardDTO dto) {
//		Member member = Member.builder().id(dto.getWriter()).build(); //작성자 객체 생성

		Board entity = Board.builder()
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(dto.getWriter())
//				.writer(member) //값 변경
				.build();
		return entity;
	}

	/* 작성자 필드 수정 */
	default BoardDTO entityToDto(Board entity) {
		BoardDTO dto = BoardDTO.builder()
				.no(entity.getNo())
				.title(entity.getTitle())
				.content(entity.getContent())
				.writer(entity.getWriter())
//				.writer(entity.getWriter().getId()) //값변경
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();

		return dto;
	}

}
