package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

public interface BookRepository2 extends JpaRepository<Book, Integer> {

	//1번. 순수한 sql을 작성한다 : SELECT * FROM tbl_book WHERE title != '자바프로그래밍입문';
	@Query(value="select * from tbl_book where title != :title",  nativeQuery = true) //3번. 쿼리에서 파라미터를 변수로 치환한다
	List<Book> get1(@Param("title") String title); //2번. 파라미터를 함수인자로 선언한다

	// SELECT * FROM tbl_book WHERE price > 20000 AND publisher = '이지스퍼블리싱'
	@Query(value="SELECT * FROM tbl_book WHERE price > :price AND publisher = :publisher", nativeQuery = true)
	List<Book> get2(@Param("price") int price, @Param("publisher") String publisher);

	// SELECT * FROM tbl_book WHERE publisher IN ('한빛출판사','남가람북스')
	@Query(value="SELECT * FROM tbl_book WHERE publisher IN (:publisher1,:publisher2)", nativeQuery = true)
	List<Book> get3(@Param("publisher1") String publisher1, @Param("publisher2") String publisher2);

}
