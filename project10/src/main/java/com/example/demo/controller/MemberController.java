package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

@Controller
//@RequestMapping("/member")
// 회원의 등급에 따라 접근을 다르게 주기 위해서 중간 경로를 지워주었다. 
// 그 다음 모든 메서드들의 return 타입을 String 으로 지정하여 직접 중간경로를 입력해준다.
public class MemberController {
	@Autowired
	private MemberService service;
	
	@GetMapping("/member/list")
	// @RequestParam 의 defaultValue 를 0으로 설정해놓아야 
	// localhost:8080/member/list?page=1 과 
	// localhost:8080/member/list 둘 다 실행 가능합니다.
	public String list(@RequestParam(defaultValue = "0") int page, Model model) {
		Page<MemberDTO> list = service.getList(page);
		model.addAttribute("list", list);
		return "member/list";
	}
	
	@GetMapping("/register")
	public String register() {
		return "member/register";
	}
	
	@PostMapping("/register")
	public String registerPost(MemberDTO dto, RedirectAttributes redirectAttributes) {
		boolean isSuccess = service.register(dto);
		if(isSuccess) {
//			return "redirect:/member/list"; // 등록성공시 목록화면으로 가기
			return "redirect:/"; // 등록 성공시 메인화면으로 이동하기 
			//(회원 가입에 성공하면 보통 메인화면으로 돌아갑니다)
		} else {
			redirectAttributes.addFlashAttribute("msg", "아이디가 중복되어 등록 실패하였습니다");
//			return "redirect:/member/register"; // 등록실패시 회원가입폼으로 돌아가기
			return "redirect:/register";
			// 등록 실패시 등록화면으로 돌아갑니다.
		}
	}
	
	// 리턴타입이 void 이므로 html 을 반환한다.
	// 매개변수로 3개가 있는데, 실제 파라미터는 id 와 page 이고 model 은 실제 파라미터가 아니다.
	// 화면단에 정보를 전해주기 위한 객체이다. 
	// 파라미터로 수집한 회원의 id 로 단건조회를 진행하고 회원의 정보를 model 에 담아주고, 
	// page 정보를 같이 넘겨주기 위해 model 에 page 번호도 같이 넣어서 html 로 넘겨준다.
	@GetMapping("/member/read")
	public String read(
						String id, 
						@RequestParam(defaultValue = "0") int page, 
						Model model
					) {
		MemberDTO dto = service.read(id);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page);
		return "member/read";
	}
	
	// 아이디 중복체크 메소드 추가
	@GetMapping("/idcheck")
	public @ResponseBody HashMap<String, Boolean> idCheck(String id) {
		HashMap<String, Boolean> result = new HashMap<String, Boolean>();
		MemberDTO memberDTO = service.read(id);
		
		if(memberDTO != null) {
			result.put("isDuplicate", true);
		} else {
			result.put("isDuplicate", false);
		}
		
		return result;
	}
}
