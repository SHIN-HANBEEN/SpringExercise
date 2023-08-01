package com.example.demo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookRepositoryTest {
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void 데이터등록() {
		Book book1 = Book.builder()
						 .price(20000)
						 .publisher("한빛출판사")
						 .title("자바프로그래밍입문")
						 .build();
		Book book2 = Book.builder()
				 .price(25000)
				 .publisher("남가람북스")
				 .title("스프링부트프로젝트")
				 .build();
		Book book3 = Book.builder()
				 .price(40000)
				 .publisher("남가람북스")
				 .title("실무로 끝내는 PHP")
				 .build();
		Book book4 = Book.builder()
				 .price(35000)
				 .publisher("이지스퍼블리싱")
				 .title("알고리즘코딩테스트")
				 .build();
		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);
		bookRepository.save(book4);
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Book> result = bookRepository.findById(1);
		result.ifPresent(book -> System.out.println(book));
	}
	
	@Test
	public void 데이터단건수정() {
		Book book = Book.builder()
						.title("값이 수정되었습니다")
						.bookNo(1)
						.build();
		bookRepository.save(book);
	}
	
	@Test 
	public void 데이터단건삭제() {
		 bookRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		bookRepository.deleteAll();
	}
}
