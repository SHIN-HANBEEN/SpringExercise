package com.example.demo.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.StudentDTO;


@Controller
@RequestMapping("/sample")
public class SampleController {
	
    @GetMapping("/ex1")
    public void ex1(Model model) {
    	StudentDTO studentDTO1 = StudentDTO.builder()
    			.no(1)
    			.name("둘리")
    			.grade(1)
    			.address("인천 구월동")
    			.build();
    	StudentDTO studentDTO2 = StudentDTO.builder()
    			.no(2)
    			.name("또치")
    			.grade(1)
    			.address("인천 구월동")
    			.build();
    	StudentDTO studentDTO3 = StudentDTO.builder()
    			.no(3)
    			.name("도우너")
    			.grade(2)
    			.address("인천 연수동")
    			.build();
    	List<StudentDTO> list = new ArrayList<>();
    	list.add(studentDTO1);
    	list.add(studentDTO2);
    	list.add(studentDTO3);
    	model.addAttribute("list", list);
    }
    
    @ResponseBody
    @GetMapping("/ex2")
    public StudentDTO ex2() {
    	StudentDTO studentDTO = StudentDTO.builder()
    			.no(1)
    			.name("둘리")
    			.grade(1)
    			.address("인천 구월동")
    			.build();
    	return studentDTO;
    }
    
    @ResponseBody
    @GetMapping("/ex3")
    public List<StudentDTO> ex3() {
    	StudentDTO studentDTO1 = StudentDTO.builder()
    			.no(1)
    			.name("둘리")
    			.grade(1)
    			.address("인천 구월동")
    			.build();
    	StudentDTO studentDTO2 = StudentDTO.builder()
    			.no(2)
    			.name("또치")
    			.grade(1)
    			.address("인천 구월동")
    			.build();
    	StudentDTO studentDTO3 = StudentDTO.builder()
    			.no(3)
    			.name("도우너")
    			.grade(2)
    			.address("인천 연수동")
    			.build();
    	List<StudentDTO> list = new ArrayList<>();
    	list.add(studentDTO1);
    	list.add(studentDTO2);
    	list.add(studentDTO3);
    	return list;
    }
    
    @ResponseBody
    @GetMapping("/ex4")
    public ResponseEntity<String> ex4() {
    	return new ResponseEntity<>("response fail..", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ResponseBody
    @GetMapping("/ex5")
    public ResponseEntity<StudentDTO> ex5() {
    	StudentDTO studentDTO1 = StudentDTO.builder()
    			.no(1)
    			.name("둘리")
    			.grade(1)
    			.address("인천 구월동")
    			.build();
    	return new ResponseEntity<>(studentDTO1, HttpStatus.BAD_REQUEST);
    }
    
    
    @GetMapping("/ex6")
    public ResponseEntity<String> ex6(
            @RequestParam("floatParam") Float floatParam,
            @RequestParam("booleanParam") Boolean booleanParam
    ) {
        String result = "float타입 파라미터 수집: " + floatParam + ", boolean타입 파라미터 수집: " + booleanParam;
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/ex7")
    public ResponseEntity<String> ex7(
    		@RequestParam("stringArrayParam") String[] stringArrayParam
    ) {
        String result = "char형 배열 수집: " + Arrays.toString(stringArrayParam) +
        		"<br>배열의 크기: " + stringArrayParam.length;
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/ex8")
    public StudentDTO ex8() {
    	StudentDTO studentDTO1 = StudentDTO.builder()
    			.no(1)
    			.name("둘리")
    			.grade(1)
    			.address("인천 구월동")
    			.build();
        return studentDTO1;
    }

    @PostMapping("/ex8")
    public void ex8(@RequestBody StudentDTO studentDTO) {
    }
    
    @GetMapping("/ex9")
    public List<StudentDTO> ex9() {
    	StudentDTO studentDTO1 = StudentDTO.builder()
    			.no(1)
    			.name("둘리")
    			.grade(1)
    			.address("인천 구월동")
    			.build();
    	StudentDTO studentDTO2 = StudentDTO.builder()
    			.no(2)
    			.name("또치")
    			.grade(1)
    			.address("인천 구월동")
    			.build();
    	StudentDTO studentDTO3 = StudentDTO.builder()
    			.no(3)
    			.name("도우너")
    			.grade(2)
    			.address("인천 연수동")
    			.build();
    	List<StudentDTO> list = new ArrayList<>();
    	list.add(studentDTO1);
    	list.add(studentDTO2);
    	list.add(studentDTO3);
    	return list;
    }

    @PostMapping("/ex9")
    public void ex9(@RequestBody List<StudentDTO> list) {
    }
}
