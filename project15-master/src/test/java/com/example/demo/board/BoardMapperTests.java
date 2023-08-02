package com.example.demo.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.domain.BoardDto;
import com.example.demo.board.mapper.BoardMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class BoardMapperTests {

	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void 게시물추가() {
		BoardDto dto = new BoardDto(0, "새로 작성하는 글", "새로 작성하는 내용", "user1", null, null);
		mapper.insert(dto);
		log.info("CREATE BOARD");
	}
	
	@Test
	public void 게시물목록조회() {
		for (BoardDto dto : mapper.selectList()) {
			log.info(dto.toString());
		}
	}

	@Test
	public void 게시물단건조회() {
		BoardDto readDto = mapper.select(5); //방금 생성된 글번호 넣기
		log.info(readDto);
	}

	@Test
	public void 게시물수정() {
		BoardDto updateDto = mapper.select(5);
		updateDto.setContent("수정된 내용");
		int result = mapper.update(updateDto);
		log.info("UPDATE BOARD: " + result);
	}

	@Test
	public void 게시물삭제() {
		int result = mapper.delete(5);
		log.info("DELETE BOARD: " + result);
	}
	
}
