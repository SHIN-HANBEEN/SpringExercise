package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.SampleDTO;

@Controller
@RequestMapping("/sample")
public class SampleController {
	@GetMapping("/ex8")
	public void ex8(Model model) {
		model.addAttribute("date", LocalDateTime.now());
	}
	
	@GetMapping("/ex7")
	public void ex7(Model model) {
		SampleDTO sampleDTO = new SampleDTO(1, "aaa", LocalDateTime.now());
		model.addAttribute("result", "success");
		model.addAttribute("dto", sampleDTO);		
	}
	
	
	@GetMapping("/ex6")
	public void ex6(Model model) {
		List<SampleDTO> list = new ArrayList<>();
		list.add(new SampleDTO(1, "aaa", LocalDateTime.now()));
		list.add(new SampleDTO(2, "bbb", LocalDateTime.now()));
		list.add(new SampleDTO(3, "ccc", LocalDateTime.now()));
		// 화면에 리스트 전달
		model.addAttribute("list", list);
	}
	
	
	@GetMapping("/ex5")
	public void ex5(Model model) {
		SampleDTO sampleDTO = new SampleDTO(1, "aaa", LocalDateTime.now());
		// 화면에 객체 전달
		model.addAttribute("dto", sampleDTO);
		
		List<SampleDTO> list = new ArrayList<>();
		list.add(new SampleDTO(1, "aaa", LocalDateTime.now()));
		list.add(new SampleDTO(2, "bbb", LocalDateTime.now()));
		list.add(new SampleDTO(3, "ccc", LocalDateTime.now()));
		// 화면에 리스트 전달
		model.addAttribute("list", list);
	}
	
	
	// ex3( ) 메서드에서 String param 을 수집해서 화면에 전달한다. 
	@GetMapping("/ex3")
	public void ex3(Model model, String param) {
		model.addAttribute("msg", param);
	}
	
	@GetMapping("/ex4")
	public void ex4(Model model) {
		model.addAttribute("msg", "hello");
	}
	
	
	@GetMapping("/ex1")
	public void ex1() {
		
	}
	
	// Model 객체는 Springframwork 가 제공하는 객체를 import 해야한다.
	// Model 은 화면에 값을 전달하는 역할
	// (변수명, 값) 화면에 문자열 전달
	// thymeleaf 를 활용하면 태그에 컨텐츠를 직접 넣어주지 않고 동적으로 처리할 수 있다.
	@GetMapping("/ex2")
	public void ex2(Model model) { 
		model.addAttribute("msg", "안녕하세요"); 
		 
	}
	
	
}

