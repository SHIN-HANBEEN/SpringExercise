package com.example.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/home")
// 아무 경로로 들어와도 /home/main 으로 보내주기 위해 중간 경로를 없애고 
// GetMapping "/" 로 설정해준다.
public class HomeController {
	// 메인화면
	@GetMapping("/")
	public String main(Principal principal, Model model) {
		model.addAttribute("id", principal.getName()); // 인증객체에서 아이디 정보를 꺼내서 전달해보자.
		return "/home/main"; //loalhost:8080 접속을 하면 home/main 이 반환이 된다. 
		// 따라서 기존에 board 패키지 밑에 있는 main html 을 옮겨준다.
	}
	
	// 커스텀 로그인 창이다.
	@GetMapping("/customlogin")
	public String customLogin() {
		return "home/login";
	}
}
