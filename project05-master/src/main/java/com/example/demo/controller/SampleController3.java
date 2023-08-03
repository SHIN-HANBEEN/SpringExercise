package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.BookDTO;

/*
 * 컨트롤러 파라미터
 * */
@Controller
@RequestMapping("/param")
public class SampleController3 {

	@GetMapping("/ex1")
	public ResponseEntity ex1(@RequestParam int i) { //단순타입은 어노테이션 생략 가능
		System.out.println("int형 파라미터 수집: " + i);
		return new ResponseEntity(HttpStatus.OK); 
		//파라미터 전송
		//localhost:8080/param/ex1?i=100
	}
	
	@GetMapping("/ex2")
	public ResponseEntity ex2(int i, char c) {
		System.out.println("int형 파라미터 수집: " + i + ", char형 파라미터 수집: " + c);
		return new ResponseEntity(HttpStatus.OK); 		
		//추가 파라미터는 &로 구분하기
		//localhost:8080/param/ex2?i=100&c=a
	}

	@GetMapping("/ex3")
	public ResponseEntity ex3(int[] arr) { //arr 이라는 이름의 파라미터가 여러개 전달되더라도 배열로 수집됨
		System.out.println("int형 배열 수집: " + Arrays.toString(arr)); //배열 -> 문자열로 변환
		return new ResponseEntity(HttpStatus.OK);
		//localhost:8080/param/ex3?arr=1&arr=2&arr=3
	}

	@GetMapping("/ex4")
	public ResponseEntity ex4(@RequestParam ArrayList<Integer> list) { //list 이라는 이름의 파라미터가 여러개 전달되더라도 리스트로 수집됨
		System.out.println("int형 리스트 수집: " + list);
		return new ResponseEntity(HttpStatus.OK);
		//localhost:8080/param/ex4?list=1&list=2&list=3
	}

	/*
	 * 날짜 패턴을 지정하고 싶으면 @DateTimeFormat 사용
	 * 기본패턴은 "yyyy-MM-dd" 
	 * 다른 패턴을 사용해도 "yyyy-MM-dd"은 기본적으로 사용 가능
	 * "yyyy/MM/dd" or "yyyyMMdd" 등 사용 가능
	 * */
	@GetMapping("/ex5")
	public ResponseEntity ex5(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		System.out.println("날짜 수집: " + date);
		return new ResponseEntity<>(HttpStatus.OK);
		//localhost:8080/param/ex5?date=2023-07-20
	}

	@GetMapping("/ex6/{i}")
	public ResponseEntity ex6(@PathVariable int i) {
		System.out.println("int형 파라미터 수집: " + i);
		return new ResponseEntity(HttpStatus.OK); 
		//localhost:8080/param/ex6/100
	}

	@GetMapping("/ex7")
	public ResponseEntity ex7(@RequestBody BookDTO dto) { //JSON -> 클래스 변환
		System.out.println("객체 수집: " + dto);
		return new ResponseEntity(HttpStatus.OK);
		//localhost:8080/param/ex7 + json
	}
	
	@GetMapping("/ex8")
	public ResponseEntity ex8(@RequestBody ArrayList<BookDTO> list) { //JSON -> 클래스 변환
		System.out.println("객체타입 리스트 수집: " + list);
		return new ResponseEntity(HttpStatus.OK);
		//localhost:8080/param/ex8 + json
	}
	
	/* ResponseEntity클래스를 사용하는 이유 */
	@GetMapping("/ex9")
	public ResponseEntity<Object> ex9(int bookNo) {
		if(bookNo>=1 && bookNo<=10) { //파라미터가 허용범위인지 체크한다
			return new ResponseEntity<>(new BookDTO("자바프로그래밍입문","한빛컴퍼니",20000), HttpStatus.OK); //성공하면 데이터를 보낸다
		}else { //파라미터 검증에 실패하면 실패 메세지를 보낸다
			return new ResponseEntity<>("번호는 1~10 사이로 입력해주세요.", HttpStatus.BAD_REQUEST);
		}
	} //localhost:8080/param/ex9?bookNo=1

}
