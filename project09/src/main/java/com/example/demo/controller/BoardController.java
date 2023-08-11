package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Slf4j 어노테이션은 롬복에서 제공하는 기능인데, 로그를 출력하는 기능입니다.
// 현재 sysout 을 사용하지만 로그를 파일에도 출력하고 싶을 때 사용합니다.
@RestController
// RestController 어노테이션을 사용해주어야 한다.
// Swagger 를 사용할 것인데, Swagger 는 @RestController 만 읽을 수 있다.
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
	
	@PostMapping
	// 모두 같은 경로를 쓰게끔 API가 설정되어 있기 때문에 
	// 중간 경로만 쓰면 되서 경로를 추가로 설정해주지 않아도 괜찮습니다.
	public ResponseEntity<Integer> register(@RequestBody BoardDTO dto) {
		log.info("게시물을 등록합니다.");
		int no = service.register(dto);
		return new ResponseEntity<>(no, HttpStatus.CREATED); // 201 성공코드(등록성공)와 새로운 글번호 반환
	}
	
	@GetMapping
	public ResponseEntity<List<BoardDTO>> getList() {
		log.info("게시물 목록을 조회합니다.");
		List<BoardDTO> list = service.getList();
		return new ResponseEntity<>(list, HttpStatus.OK); // 200 성공코드와 게시물목록 반환
	}
	
	@GetMapping("/{no}")
	public ResponseEntity<BoardDTO> read(@PathVariable("no") int no) {
		log.info("게시물을 상세 조회합니다.");
		BoardDTO dto = service.read(no);
		return new ResponseEntity<>(dto, HttpStatus.OK); // 200 성공코드와 게시물 정보를 반환
	}
	
	@PutMapping
	public ResponseEntity modify(@RequestBody BoardDTO dto) {
		log.info("게시물을 수정합니다.");
		service.modify(dto);
		return new ResponseEntity(HttpStatus.NO_CONTENT); // 204 성공 코드(삭제 혹은 삭제 성공)를 반환한다		
	}
	
	@DeleteMapping("/{no}")
	public ResponseEntity remove(@PathVariable("no") int no) {
		log.info("게시물을 삭제합니다.");
		service.remove(no);
		return new ResponseEntity(HttpStatus.NO_CONTENT); // 204 성공코드를 반환한다.
	}
	
}
