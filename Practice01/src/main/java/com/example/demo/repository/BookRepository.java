package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	//책 이름이 자바프로그래밍입문 이 아닌 책을 검색	
	//SELECT * FROM tbl_book WHERE title <> '자바프로그래밍입문';
	@Query(value = "SELECT * FROM tbl_book WHERE title <> :bookName",nativeQuery = true)
	List<Book> getBook1(@Param("bookName") String bookName);
	
	//가격이 2만원이상이고 출판사가 이지스퍼블리싱인 책을 검색
	//SELECT * FROM tbl_book WHERE price >= 20000 and publisher = '이지스퍼블리싱';
	@Query(value = "SELECT * FROM tbl_book WHERE price >= 20000 and publisher = '이지스퍼블리싱';", nativeQuery = true)
	List<Book> getBook2();
	
	// 출판사가 한빛출판사 또는 남가람북스인 책을 검색
	// SELECT * FROM tbl_book WHERE publisher = '한빛출판사' or publisher = '남가람북스';
	@Query(value = "SELECT * FROM tbl_book WHERE publisher = '한빛출판사' or publisher = '남가람북스'", nativeQuery = true)
	List<Book> getBook3();
	
	//SELECT * FROM tbl_book WHERE title = '자바프로그래밍입문';
	@Query(value = "SELECT * FROM tbl_book WHERE title = :bookName",nativeQuery = true)
	List<Book> get2(@Param("bookName") String bookName);
	
	// SELECT * FROM tbl_book WHERE price >= 30000 and publisher = '남가람북스';
    @Query(value = "SELECT * FROM tbl_book WHERE price >= :price and publisher = :publisher", nativeQuery = true)
    List<Book> get3(@Param("price") int price, @Param("publisher") String publisher);
}
