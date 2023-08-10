package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

public interface BoardService {

	// 게시물 등록
	int register(BoardDTO dto);

	// 게시물 목록조회
//	List<BoardDTO> getList();
	
	// 목록조회 메소드의 매개변수와 리턴타입을 아래와 같이 변경하였다.
	Page<BoardDTO> getList(int pageNumber);
	
	// 게시물 상세조회
	BoardDTO read(int no);

	// 게시물 수정
	void modify(BoardDTO dto);

	// 게시물 삭제
	int remove(int no);

	// dto를 엔티티로 변환하는 메소드
	default Board dtoToEntity(BoardDTO dto) { // default키워드를 사용하여 일반메소드 추가
		Member member = Member.builder().id(dto.getWriter()).build();
		// 자료형이 변했기 때문에 writer 에 member 를 바로 넣어준다.
		Board entity = Board.builder() // builder를 사용하면 필요한 값만 넣어서 인스턴스를 생성할수 있음
				.no(dto.getNo())
				.title(dto.getTitle())
				.content(dto.getContent())
				.writer(member) //날짜 생략
				.build();
		return entity;
	}

	// 엔티티를 dto로 변환하는 메소드
	default BoardDTO entityToDto(Board entity) {

		BoardDTO dto = BoardDTO.builder()
				.no(entity.getNo())
				.title(entity.getTitle())
				.content(entity.getContent())
				//.writer(entity.getWriter()) // 자료형이 달라져서 그대로 넘겨줄 수가 없다.
				.writer(entity.getWriter().getId()) // entity 안의 Member 객체를 꺼내고 그 다음 
				// 회원 아이디를 꺼내야 작성자를 얻을 수 있다.
				.regDate(entity.getRegDate())
				.modDate(entity.getModDate())
				.build();

		return dto;
	}

}
