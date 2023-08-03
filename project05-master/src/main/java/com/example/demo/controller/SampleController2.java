package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 메소드 유형
 * */
@Controller
@RequestMapping("/method")
public class SampleController2 {

	@GetMapping("/ex")
	public ResponseEntity ex1() {
		System.out.println("get메소드 요청..");
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/ex")
	public ResponseEntity ex2() {
		System.out.println("post메소드 요청..");
		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/ex")
	public ResponseEntity ex3() {
		System.out.println("put메소드 요청..");
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/ex")
	public ResponseEntity ex4() {
		System.out.println("delete메소드 요청..");
		return new ResponseEntity(HttpStatus.OK);
	}

}
