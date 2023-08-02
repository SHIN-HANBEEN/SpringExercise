package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.PersonDTO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	@GetMapping("/q7")
	public void q7(Model model) {
		List<PersonDTO> list = new ArrayList<>();
		list.add(new PersonDTO("박하나", 20, "인천 구월동"));
		list.add(new PersonDTO("홍재범", 30, "서울 구월동"));
		list.add(new PersonDTO("문유리", 40, "부산 구월동"));
		model.addAttribute("list", list);
	}
	
	@GetMapping("/q6")
	public void q6(Model model) {
		List<PersonDTO> list = new ArrayList<>();
		list.add(new PersonDTO("둘리", 20, "인천구월동"));
		
		list.add(new PersonDTO("또치", 30, "서울신림동"));
		list.add(new PersonDTO("도우너", 40, "부산문래동"));
		model.addAttribute("list", list);
	}
	
	
	@GetMapping("/q5")
	public void q5(Model model) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		model.addAttribute("list", list);
	}
	
	@GetMapping("/q4")
	public void q4(Model model) {
		PersonDTO personDTO = new PersonDTO("둘리", 20, "인천 구월동");
		model.addAttribute("personDTO",personDTO);
	}
	
	@GetMapping("/q1")
	public void q1() {
		
	}
	
	@GetMapping("/q2")
	public void q2(Model model) {
		model.addAttribute("name", "둘리");
		model.addAttribute("age", "20");
		model.addAttribute("location", "인천 구월동");
	}
}
