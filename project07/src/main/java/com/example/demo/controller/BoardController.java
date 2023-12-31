package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;



	// 목록화면
	@GetMapping("/list")
	public void list(@RequestParam(defaultValue = "0") int page,Model model) {
		Page<BoardDTO> list = service.getList(page); // 서비스로 게시물 목록 가져오기
		model.addAttribute("list", list); // 화면에 게시물 목록 전달
	}

	// 등록화면
	@GetMapping("/register")
	public void register() {
	}

	// 등록처리
	@PostMapping("/register")
	public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
		int no = service.register(dto); // 새로 추가된 엔티티의 번호
		redirectAttributes.addFlashAttribute("msg", no);
		return "redirect:/board/list";
	}

	// 상세화면
	@GetMapping("/read")
	public void read(int no, @RequestParam(defaultValue = "0") int page, Model model) {
		BoardDTO dto = service.read(no);
		model.addAttribute("dto", dto);
		model.addAttribute("page", page); // 목록으로 돌아가기할 때 목록 유지를 위한 코드
	}

	// 수정화면
	@GetMapping("/modify")
	public void modify(int no, Model model) {
		BoardDTO dto = service.read(no);
		model.addAttribute("dto", dto);
	}

	// 수정처리
	@PostMapping("/modify")
	public String modifyPost(BoardDTO dto, RedirectAttributes redirectAttributes) {
		service.modify(dto);
		redirectAttributes.addAttribute("no", dto.getNo()); //?no=1
		return "redirect:/board/read";
	}

	// 삭제처리
	@PostMapping("/remove")
	public String removePost(int no) {
		service.remove(no);
		return "redirect:/board/list";
	}

}
