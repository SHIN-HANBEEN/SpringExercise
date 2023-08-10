package com.example.demo.repository;

import com.example.demo.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface BoardRepository extends JpaRepository<Board, Integer> {

    @Modifying
    @Query("delete from Board b where b.writer = :member")
    public void deleteWriter(@Param("member") Member member);

}
