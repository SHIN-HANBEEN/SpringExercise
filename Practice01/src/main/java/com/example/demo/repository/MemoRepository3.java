package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Memo;

public interface MemoRepository3 extends JpaRepository<Memo, Integer> {
	// @Query 애노테이션을 작성할 때는 권장되는 작성 순서가 있다.
	// DBeaver 같은 프로그램을 활용하여 SQL 문을 먼저 작성한 다음 문제가 없다면
	// JPQL 을 작성해주는 것이 오류를 최소화 할 수 있는 방법입니다. 
	
	// 메모의 번호가 3보다 작은 데이터 검색
	// select * from tbl_memo where no < ?
	@Query("select m from Memo m where m.no < :mno")
	List<Memo> get1(@Param("mno") int mno);
	
	// 메모의 내용이 없는 데이터 검색
	@Query("select m from Memo m where m.text is not null")
	List<Memo> get2();
	
	// 메모의 번호가 2에서 3 사이인 데이터 검색
	@Query("select m from Memo m where m.no between :from and :to")
	List<Memo> get3(@Param("from") int from, @Param("to") int to);
	
	// 메모의 번호를 기준으로 역정렬(순수 쿼리 사용)
	@Query(value = "select * from tbl_name order by no desc", nativeQuery = true)
	List<Memo> get4();	
}

