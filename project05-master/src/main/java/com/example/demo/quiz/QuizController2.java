package com.example.demo.quiz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
@RequestMapping("/method")
public class QuizController2 {

	/*
	 * get방식 + /method/q 주소로 연결되는 메소드를 추가하세요.
	 * */
	@GetMapping("/q")
	public ResponseEntity quiz1() {
		System.out.println("get메소드 요청..");
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/*
	 * post방식 + /method/q 주소로 연결되는 메소드를 추가하세요.
	 * */
	@PostMapping("/q")
	public ResponseEntity quiz2() {
		System.out.println("post메소드 요청..");
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/*
	 * put방식 + /method/q 주소로 연결되는 메소드를 추가하세요.
	 * */
	@PutMapping("/q")
	public ResponseEntity quiz3() {
		System.out.println("put메소드 요청..");
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/*
	 * delete방식 + /method/q 주소로 연결되는 메소드를 추가하세요.
	 * */
	@DeleteMapping("/q")
	public ResponseEntity quiz4() {
		System.out.println("delete메소드 요청..");
		return new ResponseEntity(HttpStatus.OK);
	}

}
