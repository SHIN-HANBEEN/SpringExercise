package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;

import jakarta.transaction.Transactional;

@Transactional 
// JPA 가 기본으로 제공하지 않은 기능을 별도로 만들어서 사용하면 @Transactional 을 
// 함께 사용해야한다. 그래야 커밋이 진행된다.
public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	// 특정 작성자가 쓴 게시물 삭제 메소드 추가
	@Modifying // @Query 로 INSERT, DELETE, UPDATE를 작성시 선언
	@Query("delete from Board b where b.writer = :member")
	public void deleteWriter(@Param("member") Member member);
}
