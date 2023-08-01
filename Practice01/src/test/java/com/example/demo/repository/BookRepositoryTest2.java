package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;

@SpringBootTest
public class BookRepositoryTest2 {
	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void 자바프로그래밍입문아닌책검색() {
		List<Book> list = bookRepository.getBook1("자바프로그래밍입문");
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 가격2만원이상출판사이지스퍼블리싱() {
		List<Book> list = bookRepository.getBook2();
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void 가격3만원이상남가람북스검색() {
		List<Book> list = bookRepository.get3(30000,"남가람북스");
		for (Book book : list) {
			System.out.println(book);
		}
	}
}
