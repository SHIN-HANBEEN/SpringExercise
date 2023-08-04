package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
@RequestMapping("/param")
public class SampleController3 {
	@GetMapping("/q5vol2")
	public ResponseEntity<String> q5vol2(int i, @RequestBody List<StudentDTO> list) {
		if (i >= 1 && i <= 3) {
			return new ResponseEntity<String>(
					i + "번에 해당하는 학생정보 : " + list.get(i-1), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(
					"1~3 사이의 학생 번호를 입력하세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/q6")
	public ResponseEntity<List<CarDTO>> q6(@RequestBody List<CarDTO> list) {
		System.out.println("객체타입 리스트 수집: " + list);
		for (CarDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println("마지막 요소 : " + list.get(list.size()-1));
		return new ResponseEntity<List<CarDTO>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/q5")
	public ResponseEntity<List<StudentDTO>> q5(@RequestBody List<StudentDTO> list) {
		System.out.println("객체타입 리스트 수집: " + list);
		for (StudentDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println("리스트의 개수: " + list.size());
		return new ResponseEntity<List<StudentDTO>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/q4")
	public ResponseEntity<Object> q4(@RequestBody StudentDTO dto) {
		System.out.println("객체 수집: " + dto);
		return new ResponseEntity<Object>(dto, HttpStatus.OK);
	}
	
	
	@GetMapping("/q3")
	public ResponseEntity<String> q3(char[] arr) {
		String result = "char형 배열 수집: " + Arrays.toString(arr) + "\n";
		for (char c : arr) {
			result = result + c + "\n";
		}
		result = result + "배열의 개수: " + arr.length;
		return new ResponseEntity<String>(result, HttpStatus.OK);
		// localhost:8080/param/q3?arr=a&arr=b&arr=c
	}
	
	@GetMapping("/q2")
	public ResponseEntity<String> q2(Float f, boolean b) {
		return new ResponseEntity<String>(
				"Float타입 파라미터 수집: " + f + ", boolean타입 파라미터 수집: " + b, HttpStatus.OK);
		// localhost:8080/param/q2?f=1.55&b=true
	}
	
	
	
	@GetMapping("/q1")
	public ResponseEntity<String> q1(String s) {
		return new ResponseEntity<String>("String타입 파라미터 수집: " + s, HttpStatus.OK);
		// localhost:8080/param/q1?s=hello
	}
	
	
	
	@GetMapping("/ex10")
	public ResponseEntity<Object> ex10(int bookNo) {
		if(bookNo>=1 && bookNo<=10) {
			return new ResponseEntity<Object>(
					new BookDTO("자바프로그래밍입문", "한빛컴퍼니", 20000), HttpStatus.OK);
			// localhost:8080/param/ex10?bookNo=5
		} else {
			return new ResponseEntity<Object>(
					"번호는 1~10 사이로 입력해주세요.", HttpStatus.BAD_REQUEST);
			// localhost:8080/param/ex10?bookNo=100
		}
	}
	
	@GetMapping("/ex8")
	public ResponseEntity ex8(@RequestBody BookDTO dto) {
		System.out.println("객체 수집: " + dto);
		return new ResponseEntity(HttpStatus.OK);
		// localhost:8080/param/ex8 + json
	}
	
	@GetMapping("/ex9")
	public ResponseEntity ex9(@RequestBody ArrayList<BookDTO> list) {
		System.out.println("객체타입 리스트 수집: " + list);
		return new ResponseEntity(HttpStatus.OK);
		// localhost:8080/param/ex9 + json
	}
	
	@GetMapping("/ex7/{i}")
	public ResponseEntity ex7(@PathVariable int i) {
		System.out.println("int 형 파라미터 수집 : " + i);
		return new ResponseEntity(HttpStatus.OK);
		// localhost:8080/param/ex7/100
	}
	
	@GetMapping("/ex5")
	public ResponseEntity ex5(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		System.out.println("날짜 수집 : " + date);
		return new ResponseEntity(HttpStatus.OK);
		// localhost:8080/param/ex5?date=2023-07-20
	}
	
	@GetMapping("/ex6")
	public ResponseEntity ex6(@DateTimeFormat(pattern = "yyyy/MM/dd") LocalDate date) {
		System.out.println("날짜 수집 : " + date);
		return new ResponseEntity(HttpStatus.OK);
		// localhost:8080/param/ex5?date=2023/07/20
	}

	@GetMapping("/ex3")
	public ResponseEntity ex3(int[] arr) {
		System.out.println("int 형 배열 수집 : " + Arrays.toString(arr));
		return new ResponseEntity(HttpStatus.OK);
		// localhost:8080/param/ex3?arr=1&arr=2&arr=3
	}
	
	@GetMapping("/ex4")
	public ResponseEntity ex4(@RequestParam ArrayList<Integer> list) {
		System.out.println("int형 리스트 수집 : " + list);
		return new ResponseEntity(HttpStatus.OK);
		// localhost:8080/param/ex4?list=1&list=2&list=3
	}
	
	
	@GetMapping("/ex1")
	public ResponseEntity ex1(@RequestParam int i) {
		System.out.println("int 형 파라미터 수집 : " + i);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/ex2")
	public ResponseEntity ex2(int i, char c) { // 단순타입은 어노테이션 생략이 가능하다.
		System.out.println("int 형 파라미터 수집 : " + i + ", char형 파라미터 수집: " + c);
		return new ResponseEntity(HttpStatus.OK);
		// 추가 파라미터를 사용자가 입력할 때는 &로 구분한다.
		// localhost:8080/param/ex2?i=100&c=a 가 예시이다.
	}
		
}

