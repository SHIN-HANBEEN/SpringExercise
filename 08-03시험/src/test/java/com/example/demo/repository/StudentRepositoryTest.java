package com.example.demo.repository;

import static org.mockito.ArgumentMatchers.anyList;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Student;


@SpringBootTest
public class StudentRepositoryTest {

	@Autowired
	StudentRepository studentRepository;
	
	@Test
	public void 등록() {
		Student student1 = Student.builder()
				.address("인천 구월동")
				.grade(1)
				.name("둘리")
				.build();
		Student student2 = Student.builder()
				.address("인천 구월동")
				.grade(1)
				.name("또치")
				.build();
		Student student3 = Student.builder()
				.address("인천 연수동")
				.grade(2)
				.name("도우너")
				.build();
		Student student4 = Student.builder()
				.address("서울 신림동")
				.grade(2)
				.name("마이콜")
				.build();
		Student student5 = Student.builder()
				.address("부산 문래동")
				.grade(3)
				.name("고길동")
				.build();
		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		list.add(student4);
		list.add(student5);
		studentRepository.saveAll(list);
	}
	
	@Test
	public void 조회() {
		System.out.println(studentRepository.findAll());
		System.out.println(studentRepository.findById(1));
	}
	
	@Test
	public void 주소변경() {
		Student student = Student.builder().no(1).address("인천 학익동")
									.grade(1)
									.name("둘리")
									.build();
		studentRepository.save(student);
	}
	
	@Test
	public void 학생삭제() {
		studentRepository.deleteById(1);
	}

}
