package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository boardRepository;
	
	@Test
	public void 데이터등록() {
		Board board1 = new Board();
		board1.setTitle("1번글");
		board1.setContent("내용입니다");
		boardRepository.save(board1);
		Board board2 = new Board(0, "2번글", "내용입니다", null, null);
		boardRepository.save(board2);
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Board> result = boardRepository.findById(1);
		if(result.isPresent()) {
			Board board = result.get();
			System.out.println(board);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Board> list = boardRepository.findAll();
		for(Board board: list) {
			System.out.println(board);
		}
	}
	
	@Test 
	public void 데이터수정() {
		// 목록조회 -> 상세조회 -> 수정
		Optional<Board> result = boardRepository.findById(1);
		Board board = result.get();
		board.setContent("내용이수정되었습니다");
		boardRepository.save(board);
	}
	
	@Test
	public void 데이터삭제() {
		// 목록조회 -> 상세조회 -> 삭제
		boardRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		boardRepository.deleteAll();
	}
}
