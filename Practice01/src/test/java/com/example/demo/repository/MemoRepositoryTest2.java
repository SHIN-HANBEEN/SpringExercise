package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest2 {
	@Autowired
	MemoRepository2 memoRepository;
	
	@Test
	public void 번호가3보다작은_메모검색() {
		List<Memo> list = memoRepository.findByNoLessThan(3);
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void text가NUll이아닌_메모검색() {
		List<Memo> list = memoRepository.findByTextIsNotNull();
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호가2와3사이인_메모검색() {
		List<Memo> list = memoRepository.findByNoBetween(2, 3);
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호를기준으로역정렬한_메모검색() {
		List<Memo> list = memoRepository.findAllByOrderByNoDesc();
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 번호가3보다작은_메모삭제() {
		memoRepository.deleteMemoByNoLessThan(3);
	}
}
