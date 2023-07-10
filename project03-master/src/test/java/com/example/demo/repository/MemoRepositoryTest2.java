package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

/*
 * 메모리 리자피토리의 쿼리메소드를 사용해서 
 * 메모테이블에서 조건검색한 데이터를 가져오는지 확인한다.
 * */
@SpringBootTest
public class MemoRepositoryTest2 {

	@Autowired
	MemoRepository2 memoRepository;
	
	@Test
	public void 번호가3보다작은_메모검색() {
		//테이블 삭제하고 메모 3건 다시 추가
		List<Memo> list = memoRepository.findByNoLessThan(3);
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 텍스트가null이아닌_메모검색() {
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
		memoRepository.deleteMemoByNoLessThan(3); //에러남
		//엔티티를 삭제할 때는 @Transactional을 사용해야한다
	}
}
