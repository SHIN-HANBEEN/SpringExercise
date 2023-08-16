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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// Slf4j 어노테이션은 롬복에서 제공하는 기능인데, 로그를 출력하는 기능입니다.
// 현재 sysout 을 사용하지만 로그를 파일에도 출력하고 싶을 때 사용합니다.
@RestController
// RestController 어노테이션을 사용해주어야 한다.
// Swagger 를 사용할 것인데, Swagger 는 @RestController 만 읽을 수 있다.
// Swagger 는 API 문서를 자동으로 만들어주는 기능을 수행하는데, 
// /swagger 라는 주소로 들어가면 문서를 확인할 수 있다.
@Tag(name = "게시물 관리 API", description = "Swagger 테스트용 API")
// Swagger 의 제목과 설명을 달아주는 Tag Annotation 입니다.
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
	
	@PostMapping
	// 모두 같은 경로를 쓰게끔 API가 설정되어 있기 때문에 
	// 중간 경로만 쓰면 되서 경로를 추가로 설정해주지 않아도 괜찮습니다.
	// 아래 매개변수를 보면 dto 를 받는다고 되어 있는데, 실제로 웹에서 받는 것은
	// Json 입니다. Jackson 이 json 을 dto 로 뒤에서 자동으로 변환을 해주고 이었습니다. 
	@Operation(summary = "게시물 등록", description = "파라미터로 받은 게시물 정보를 등록합니다.")
	// Swagger 에서 해당 메서드 요약과 설명을 추가하는 annotation 입니다.
	public ResponseEntity<Integer> register(@RequestBody BoardDTO dto) {
		log.info("게시물을 등록합니다.");
		int no = service.register(dto);
		return new ResponseEntity<>(no, HttpStatus.CREATED); // 201 성공코드(등록성공)와 새로운 글번호 반환
	}
	
	// @ResponseBody 애노테이션이 생략되어 있는데,
	// 그 이유는 @RestController 가 @ResponseBody 를 갖고 있기 때문입니다. 
	@GetMapping
	@Operation(summary = "게시물 목록 조회", description = "모든 게시물 정보를 조회합니다.")
	// Swagger 에서 해당 메서드 요약과 설명을 추가하는 annotation 입니다.
	public ResponseEntity<List<BoardDTO>> getList() {
		log.info("게시물 목록을 조회합니다.");
		List<BoardDTO> list = service.getList();
		return new ResponseEntity<>(list, HttpStatus.OK); // 200 성공코드와 게시물목록 반환
	}
	
	// PathVariable 을 상요할 때는 주소의 이름과 애노테이션 값이 같아야 한다. 
	@GetMapping("/{no}")
	@Operation(summary = "게시물 상세 조회", description = "모든 게시물 정보를 조회합니다")
	// Swagger 에서 해당 메서드 요약과 설명을 추가하는 annotation 입니다.
	public ResponseEntity<BoardDTO> read(@PathVariable("no") int no) {
		log.info("게시물을 상세 조회합니다.");
		BoardDTO dto = service.read(no);
		// 현재 dto 를 반환하는 것을 볼 수 있는데, 클라이언트에게는 Json 으로 보내야합니다.
		// 이것을 뒤에서 자동으로 처리해주고 있는 것이 Jackson 라이브러리입니다.
		return new ResponseEntity<>(dto, HttpStatus.OK); // 200 성공코드와 게시물 정보를 반환
	}
	
	// 게시물 수정을 할 때는 게시물 번호(ID)를 생략하면 안되는데, 
	// 어떤 게시물을 생략할 것인지 알려주어야 하기 때문이다. 
	// 즉, 사용자로부터 받는 것은 dto 이기 때문에 dto 에 게시물 번호(ID)를 갖고 있어야 한다.
	@PutMapping
	@Operation(summary = "게시물 수정", description = "게시물을 수정합니다.")
	// Swagger 에서 해당 메서드 요약과 설명을 추가하는 annotation 입니다.
	public ResponseEntity modify(@RequestBody BoardDTO dto) {
		log.info("게시물을 수정합니다.");
		service.modify(dto);
		return new ResponseEntity(HttpStatus.NO_CONTENT); // 204 성공 코드(삭제 혹은 삭제 성공)를 반환한다		
	}
	
	@DeleteMapping("/{no}")
	@Operation(summary = "게시물 삭제", description = "게시물을 삭제합니다.")
	// Swagger 에서 해당 메서드 요약과 설명을 추가하는 annotation 입니다.
	public ResponseEntity remove(@PathVariable("no") int no) {
		log.info("게시물을 삭제합니다.");
		service.remove(no);
		return new ResponseEntity(HttpStatus.NO_CONTENT); // 204 성공코드를 반환한다.
	}
	
}
