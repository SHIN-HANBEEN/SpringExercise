package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.CarDTO;
import com.example.demo.dto.PersonDTO;
import com.example.demo.dto.StudentDTO;


@Controller
@RequestMapping("/return")
public class SampleController1 {
	@ResponseBody
	@GetMapping("/q5")
	public List<StudentDTO> q5() {
		StudentDTO studentDTO1 = new StudentDTO(1, "둘리", 3);
		StudentDTO studentDTO2 = new StudentDTO(2, "또치", 1);
		StudentDTO studentDTO3 = new StudentDTO(3, "도우너", 2);
		List<StudentDTO> list = new ArrayList<>();
		list.add(studentDTO1);
		list.add(studentDTO2);
		list.add(studentDTO3);
		return list;
	}
	
	
	@ResponseBody
	@GetMapping("/q4")
	public CarDTO q4() {
		CarDTO carDTO = new CarDTO("현대", "코나", "블랙");
		return carDTO;
	}
	
	@ResponseBody
	@GetMapping("/q3")
	public StudentDTO q3() {
		StudentDTO studentDTO = new StudentDTO(1, "둘리", 3);
		return studentDTO;
	}
	
	@GetMapping("/q2")
	public String q2() {
		return "/return/test.html";
	}
	
	@GetMapping("/q1")
	public String q1() {
		return "/return/ex1.html";
	}
	
	
	
	@GetMapping("/ex5")
	public ResponseEntity ex5() {
		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// 출력 메세지가 없으면 제네릭 타입은 생략합니다.
	
	@GetMapping("/ex6")
	public ResponseEntity<String> ex6() {
		return new ResponseEntity("success..", HttpStatus.OK);
	}
	
	@GetMapping("/ex7")
	public ResponseEntity<BookDTO> ex7() {
		BookDTO bookDTO = new BookDTO("자바프로그래밍입문", "한빛컴퍼니", 20000);
		return new ResponseEntity(bookDTO, HttpStatus.OK);
	}
	// ResponseEntity 의 제네릭 형은 반환하는 ResponseEntity 의 첫번째 인자 자료형을 사용한다.
	
	@ResponseBody
	@GetMapping("/ex3")
	public BookDTO ex3() {
		BookDTO bookDTO = new BookDTO("자바프로그래밍입문", "한빛컴퍼니", 20000);
		return bookDTO;
	}
	
	@ResponseBody
	@GetMapping("/ex4")
	public List<BookDTO> ex4() {
		List<BookDTO> list = new ArrayList<>();
		list.add(new BookDTO("자바프로그래밍입문", "한빛컴퍼니", 20000));
		list.add(new BookDTO("스프링부트웹프로젝트", "구멍가게코딩단", 15000));
		list.add(new BookDTO("모두의리눅스", "길벗출판사", 30000));
		return list;
	}
	
	@GetMapping("/ex2")
	public String ex2() {
		// 반환타입 String 으로 HTML 경로를 지정하여 반환할 수 있다.
		return "/return/ex1.html"; 
	}
	
	@GetMapping("/ex1")
	public void ex1() {
		// 
	}
	

}
