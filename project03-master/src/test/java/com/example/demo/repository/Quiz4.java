package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Book;
import com.example.demo.entity.Gift;
import com.example.demo.entity.Memo;

@SpringBootTest
public class Quiz4 {

	@Autowired
	BookRepository2 bookRepository2;
	
	@Test
	public void 이름이자바프로그래밍입문이아닌_책검색() {
		List<Book> list = bookRepository2.get1("자바프로그래밍입문");
		for(Book book : list) {
			System.out.println(book);
		}
	}

	@Test
	public void 가격이2만원이상이고_출판사가이지스퍼블리싱인_책검색() {
		List<Book> list = bookRepository2.get2(20000,"이지스퍼블리싱");
		for(Book book : list) {
			System.out.println(book);
		}
	}

	@Test
	public void 출판사가_한빛출판사또는남가람북스인_책검색() {
		List<Book> list = bookRepository2.get3("한빛출판사","남가람북스");
		for(Book book : list) {
			System.out.println(book);
		}
	}
	
}
