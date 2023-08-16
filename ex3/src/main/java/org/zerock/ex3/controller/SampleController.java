package org.zerock.ex3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {
	@GetMapping("/exLayout1")
	public void exLayout1() {
		log.info("exLayout..........");
	}
	
    @GetMapping("/ex1")
    public void ex1() {
        log.info("ex1...............");
    }
}
