package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.demo.dto.BoardDTO;

@SpringBootTest
public class BoardServiceTest {

	@Autowired
	BoardService service;

	@Test
	public void 게시물30개추가() {
		for (int i=1; i<=30; i++) {
			service.register(new BoardDTO(0, i + "번글", "안녕하세요",
					"둘리", null, null));
		}
	}
	
	@Test
	public void 첫번째페이지의게시물목록조회() {
		Page<BoardDTO> page = service.getList(1);
		List<BoardDTO> list = page.getContent(); //게시물 목록 꺼내기
		for(BoardDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 게시물등록() {
//		BoardDTO dto = new BoardDTO(0,"1번글","내용입니다","둘리",null,null);
		BoardDTO dto = new BoardDTO(0,"2번글","내용입니다","또치",null,null);
		int no = service.register(dto);
		System.out.println("새로운 게시물 번호: " + no);
	}
	
	@Test
	public void 게시물목록조회() {
		Page<BoardDTO> list = service.getList(0);
		for(BoardDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	@Test
	public void 게시물단건조회() {
		BoardDTO dto = service.read(1);
		System.out.println(dto);
	}
	
	@Test
	public void 게시물수정() {
		BoardDTO dto = service.read(1);
		dto.setContent("내용이수정되었습니다~");
		service.modify(dto);
	}
	
	@Test
	public void 게시물삭제() {
		service.remove(1);
	}

}
