package com.example.demo.controller;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/member/list")
	public void list(@RequestParam(defaultValue = "0") int page, Model model) {
		Page<MemberDTO> list = service.getList(page);
		model.addAttribute("list", list);	
	}

	@GetMapping("/register")
	public String register() {
		return "member/register";
	}

	@PostMapping("/register")
	public String registerPost(MemberDTO dto, RedirectAttributes redirectAttributes) {
		boolean isSuccess = service.register(dto);
		if(isSuccess) {
			return "redirect:/";
		}else {
			redirectAttributes.addFlashAttribute("msg", "아이디가 중복되어 등록에 실패하였습니다");
			return "redirect:/register";
		}
	}

	@GetMapping("/member/read")
	public void read(String id, @RequestParam(defaultValue = "0") int page, Model model) {
		MemberDTO dto = service.read(id);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
	}
	
	//아이디 중복체크 메소드 추가
	@GetMapping("/idcheck")
	public @ResponseBody HashMap<String, Boolean> idCheck(String id) {
		HashMap<String, Boolean> result = new HashMap<String, Boolean>();
		MemberDTO memberDto = service.read(id);
		if(memberDto != null) {
			result.put("isDuplicate",true);
		}else {
			result.put("isDuplicate",false);
		}
		return result;
	}

}
