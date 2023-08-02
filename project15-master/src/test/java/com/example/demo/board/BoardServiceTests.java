package com.example.demo.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.domain.BoardDto;
import com.example.demo.board.service.BoardService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void 게시물추가() {
		BoardDto dto = new BoardDto(0, "새로 작성하는 글", "새로 작성하는 내용", "user1", null, null);
		BoardDto newDto = service.register(dto);
		log.info("Register Board: " + newDto.toString()); //selectKey메소드에서 새로운 시퀀스번호를 BoardDto에 저장했음
		// 때문에 변경된 board dto 정보를 확인할수 있다
	}

	@Test
	public void 게시물목록조회() {
		for (BoardDto dto : service.getList()) {
			log.info(dto.toString());
		}
	}

	@Test
	public void 게시물상세조회() {
		log.info(service.get(7)); //새로운 글번호로 변경
	}

	@Test
	public void 게시물수정() {
		BoardDto dto = service.get(7);
		dto.setTitle("수정된 글");		
		boolean isSuccess = service.modify(dto);
		if(isSuccess) {
			log.info("수정을 성공했습니다");
		} else {
			log.info("수정을 실패했습니다");
		}
	}
	
	@Test
	public void 게시물삭제() {
		boolean isSuccess = service.remove(7);
		if(isSuccess) {
			log.info("삭제를 성공했습니다");
		} else {
			log.info("삭제를 실패했습니다");
		}
	}


}
