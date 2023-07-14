package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository2 extends JpaRepository<Memo, Integer> {
	
	List<Memo> findbynolessthan
}
