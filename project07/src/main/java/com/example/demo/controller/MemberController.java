package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService service;
	
	@GetMapping("/list")
	// @RequestParam 의 defaultValue 를 0으로 설정해놓아야 
	// localhost:8080/member/list?page=1 과 
	// localhost:8080/member/list 둘 다 실행 가능합니다.
	public void list(@RequestParam(defaultValue = "0") int page, Model model) {
		Page<MemberDTO> list = service.getList(page);
		model.addAttribute("list", list);
	}
}
