package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
	@GetMapping("/ex1")
	public void ex1() {
		
	}
	
	// Model 객체는 Springframwork 가 제공하는 객체를 import 해야한다.
	@GetMapping("/ex2")
	public void ex2(Model model) { // Model 은 화면에 값을 전달하는 역할
		model.addAttribute("msg", "안녕하세요"); // (변수명, 값) 화면에 문자열 전달
	}
}

