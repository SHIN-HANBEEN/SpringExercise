package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

@Transactional
// 쿼리 메서드로 deleteby 를 사용하려면 @Transactional 을 사용해야 한다.
// 왜냐하면 JPA가 기본적으로 제공하는 CRUD는 Transaction 을 자동으로 제공하지만
// 우리가 직접 정의하는 쿼리메서드는 Transaction 을 우리가 처리를 해주어야 하기 때문이다. 
// Transaction 이 필요한 이유는 우리가 작성한 SQL이 DB에 실질적으로 영향을 미치는 
// DELETE 같은 것일 경우에는 @Transactional 어노테이션을 사용해야 
// 실제 DB에 커밋이 진행되어 반영이 된다. 
public interface MemoRepository2 extends JpaRepository<Memo, Integer>{
	// 메모의 번호가 mno 보다 작은 데이터검색
	// select * from tbl_memo where no < ?
	List<Memo> findByNoLessThan(int mno);
	
	// 메모의 내용이 없는 데이터 검색
	List<Memo> findByTextIsNotNull();
	
	// 메모의 번호가 from 에서 to 사이인 데이터 검색
	List<Memo> findByNoBetween(int from, int to);
	
	// 조건 검색이 아닌 그냥 정렬 하고 싶을 때는 findAllBy 를 사용해야한다.
	// select * from tbl_memo orderby no desc
	List<Memo> findAllByOrderByNoDesc();
	
	// 메모의 번호가 mno 보다 작은 데이터 삭제
	// delete from tbl_memo where no < ?
	void deleteMemoByNoLessThan(int mno);
}
