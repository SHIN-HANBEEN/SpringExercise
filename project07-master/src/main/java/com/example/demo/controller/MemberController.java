package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/list")
	public void list(@RequestParam(defaultValue = "0") int page, Model model) { //파라미터 추가
		Page<MemberDTO> list = service.getList(page);
		model.addAttribute("list", list);	
	}

	@GetMapping("/register")
	public void register() {
	}

	@PostMapping("/register")
	public String registerPost(MemberDTO dto, RedirectAttributes redirectAttributes) {
		boolean isSuccess = service.register(dto);
		if(isSuccess) {
			return "redirect:/member/list"; //등록성공시 목록화면으로 가기
		}else {
			redirectAttributes.addFlashAttribute("msg", "아이디가 중복되어 등록에 실패하였습니다");
			return "redirect:/member/register"; //등록실패시 회원가입폼으로 돌아가기
		}
	}

	@GetMapping("/read")
	public void read(String id, @RequestParam(defaultValue = "0") int page, Model model) { //파라미터 추가
		MemberDTO dto = service.read(id);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
	}

}
