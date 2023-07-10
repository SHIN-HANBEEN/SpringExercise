package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

/* 쿼리메소드 사용하기 
 * */
@Transactional
public interface MemoRepository2 extends JpaRepository<Memo, Integer> {
	
	//메모 객체의 no값이 3보다 작은 객체 구함	
	//select * from tbl_memo where no < 3
	List<Memo> findByNoLessThan(int mno); //쿼리에 필요한 값을 입력받기 위해 인자 선언
	
	//메몸 객체의 text값이 빈값이 객체 구함
	//select * from tbl_memo where text is not null
	List<Memo> findByTextIsNotNull();
	
	//메모 객체의 no값이 2에서 3 사이인 객체 구함
	//select * from tbl_memo where no between 2 and 3
	List<Memo> findByNoBetween(int from, int to); //쿼리에 필요한 값을 입력받기 위해 인자 선언
	
	//메몸 객체를 no를 기준으로 역정렬함
	//select * from tbl_memo orderby no desc
	List<Memo> findAllByOrderByNoDesc();
	
	//메모 객체의 no값이 3보다 작은 객체 삭제
	//delete from tbl_memo where no < 3
	void deleteMemoByNoLessThan(int mno);
	
}

