package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.SampleDTO;

/*
 * 리턴 타입이 void인 경우,url 경로와 일치하는 html 파일을 찾아 반환
 * 파일경로: templates/ + sample/ + ex.html
 * */

@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex1")
    public void ex1() {
    }

    @GetMapping("/ex2")
    public void ex2(Model model) { //Model은 화면에 값을 전달하는 역할
        model.addAttribute("msg", "aaa"); //(변수명,값) 화면에 문자열 전달
    }

    @GetMapping("/ex3")
    public void ex3(Model model) {
        SampleDTO sampleDTO = new SampleDTO(1, "aaa", LocalDateTime.now());
        model.addAttribute("dto", sampleDTO); //화면에 객체 전달
    }

    @GetMapping("/ex4")
    public void ex4(Model model) {
        List<SampleDTO> list = new ArrayList<>();
        list.add(new SampleDTO(1, "aaa", LocalDateTime.now()));
        list.add(new SampleDTO(2, "bbb", LocalDateTime.now()));
        list.add(new SampleDTO(3, "ccc", LocalDateTime.now()));
        model.addAttribute("list", list); //화면에 리스트 전달
    }

    @GetMapping("/ex5")
    public void ex5(Model model) {
        SampleDTO sampleDTO = new SampleDTO(1, "aaa", LocalDateTime.now());
        model.addAttribute("result", "success"); //화면에 문자열 전달
        model.addAttribute("dto", sampleDTO); //화면에 객체 전달
    }

    @GetMapping("/ex6")
    public void ex6(Model model) {
        SampleDTO sampleDTO = new SampleDTO(1, "aBC", LocalDateTime.now());
        model.addAttribute("dto", sampleDTO); //화면에 객체 전달
    }

    @GetMapping("/exLayout")
    public void ex7() {
    }

    @GetMapping("/exSidebar")
    public void ex8() {
    }

}
