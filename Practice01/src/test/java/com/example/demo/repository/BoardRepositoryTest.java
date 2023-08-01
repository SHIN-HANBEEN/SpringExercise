package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;
import com.example.demo.entity.Memo;

import lombok.Builder;

@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	BoardRepository boardRepository;

	@Test
	public void 데이터등록() {
		// default 생성자 사용
		Board board1 = new Board();
		board1.setTitle("1번글");
		board1.setContent("내용입니다");
		boardRepository.save(board1);
		// 생성자 사용
		Board board2 = new Board(0, "2번글", "내용입니다", null, null);
		boardRepository.save(board2);

		// builder 메소드를 사용해서 세번째 엔티티 생성하기
		Board board3 = Board.builder()
							.content("내용입니다")
							.title("3번글")
							.build();
		boardRepository.save(board3);
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Board> result = boardRepository.findById(1);
		// if 구문
//		if(result.isPresent()) {
//			Board board = result.get();
//			System.out.println(board);
//		}
		// 람다식
		result.ifPresent(board -> System.out.println(board));
	}
	
	@Test
	public void 데이터전체조회() {
		List<Board> list = boardRepository.findAll();
		for (Board board : list) {
			System.out.println(board);
		}
		// 일반형태 포문
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void 데이터수정() {
		Board board = Board.builder().boardNo(2).build();
		boardRepository.save(board);
	}

	@Test
	public void 데이터삭제() {
		boardRepository.deleteById(1);
	}

	@Test
	public void 데이터전체삭제() {
		boardRepository.deleteAll();
	}
}
