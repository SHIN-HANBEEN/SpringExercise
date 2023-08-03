package com.example.demo.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.CarDTO;
import com.example.demo.dto.StudentDTO;

@Controller
@RequestMapping("/param")
public class QuizController3 {

	/*
	 * get방식 + /param/q1 주소로 연결되는 메소드를 추가하세요.
	 * 문자열 파라미터를 수집하세요.
	 */
	@GetMapping("/q1")
	public ResponseEntity quiz1(String str) {
		System.out.println("String타입 파라미터 수집: " + str);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/*
	 * get방식 + /param/q2 주소로 연결되는 메소드를 추가하세요.
	 * 실수 파라미터와 논리형 파라미터를 수집하세요.
	 */
	@GetMapping("/q2")
	public ResponseEntity quiz2(float f, boolean b) {
		System.out.println("float타입 파라미터 수집: " + f + ", boolean타입 파라미터 수집: " + b);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/*
	 * get방식 + /param/q3 주소로 연결되는 메소드를 추가하세요.
	 * 문자형 배열 파라미터를 수집하세요.
	 * 그리고 콘솔창에 배열의 요소를 하나씩 출력하고, 배열의 개수를 출력하세요.
	 */
	@GetMapping("/q3")
	public ResponseEntity quiz3(char[] arr) {
		System.out.println("char형 배열 수집: " + Arrays.toString(arr)); //배열 -> 문자열로 변환
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("배열의 개수:" + arr.length);
		return new ResponseEntity(HttpStatus.OK); 
	}

	/*
	 * post방식 + /param/q4 주소로 연결되는 메소드를 추가하세요.
	 * 학생정보 파라미터를 수집하세요.
	 */
	@PostMapping("/q4")
	public ResponseEntity quiz4(@RequestBody StudentDTO dto) { //JSON -> 클래스 변환
		System.out.println("객체 수집: " + dto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/*
	 * post방식 + /param/q5 주소로 연결되는 메소드를 추가하세요.
	 * 학생 목록 파라미터를 수집하세요.
	 * 그리고 콘솔창에 배열의 요소를 하나씩 출력하고, 목록의 개수를 출력하세요.
	 */
	@PostMapping("/q5")
	public ResponseEntity quiz5(@RequestBody ArrayList<StudentDTO> list) { //JSON -> 클래스 변환
		System.out.println("객체타입 리스트 수집: " + list);
		for(StudentDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println("리스트의 개수:" + list.size());
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/*
	 * post방식 + /param/q6 주소로 연결되는 메소드를 추가하세요.
	 * 자동차 목록 파라미터를 수집하세요.
	 * 그리고 리스트의 마지막 요소를 출력하세요.
	 */
	@PostMapping("/q6")
	public ResponseEntity quiz6(@RequestBody ArrayList<CarDTO> list) { //JSON -> 클래스 변환
		int size = list.size();
		System.out.println("객체타입 리스트 수집: " + list);
		for(CarDTO dto : list) {
			System.out.println(dto);
		}
		System.out.println("리스트 마지막 요소: " + list.get(size-1));
		return new ResponseEntity(HttpStatus.OK);
	}

}
