package com.example.demo.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.domain.EmpDto;
import com.example.demo.emp.mapper.EmpMapper;

/*
 * 퀴즈. 사원테이블을 사용하여 매퍼 만들기
 * */

@SpringBootTest
public class EmpMapperTests {

	@Autowired
	private EmpMapper mapper;
	

	@Test
	public void 사원추가() {
		EmpDto dto = new EmpDto(1004, "둘리", 3);
		int result = mapper.insert(dto);
		System.out.println("CREATE USER: " + result);
	}
	
	@Test
	public void 사원목록조회() {
		for (EmpDto dto : mapper.selectList()) {
			System.out.println(dto.toString());
		}
	}
	
	@Test
	public void 사원상세조회() {
		EmpDto readDto = mapper.select(1004);
		System.out.println(readDto);
	}

	@Test
	public void 사원정보수정() {
		EmpDto updateDto = mapper.select(1004); // 사원정보를 불러와서
		updateDto.setEmpName("또치"); //부분적으로 정보를 변경
		int result = mapper.update(updateDto); //수정
		System.out.println("UPDATE USER: " + result);
	}

	@Test
	public void 사원정보삭제() {
		int result = mapper.delete(1004);
		System.out.println("DELETE USER: " + result);
	}
}
