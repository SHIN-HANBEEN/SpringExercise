package com.example.demo.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest {
	// MemoRepository 가 jpaRepository 를 상속받으면서 자동으로 컨테이너에 등록되었고
	// 그것을 Test 파일에서 Autowired 해서 사용하고 있는 것이다.
	@Autowired
	MemoRepository memoRepository;
	
	@Test
	public void testPageDefault() {
		// 1페이지 10개
		Pageable pageable = PageRequest.of(0, 10);
		
		Page<Memo> result = memoRepository.findAll(pageable);
		
		System.out.println(result);
	}
	
	@Test
	public void testDelete() {
		Long mno = 100L;
		memoRepository.deleteById(mno);
	}
	
	
	@Test
	public void testUpdate() {
		Memo memo = Memo.builder()
					.mno(100L)
					.memoText("Update Text")
					.build();
		memoRepository.save(memo);
		Long mno = 100L;
		Optional<Memo> search = memoRepository.findById(mno);
		System.out.println("============");
		if (search.isPresent()) {
			System.out.println(search.get());
		}
	}
	
	@Test
	public void testUpdate2() {
		Memo memo = Memo.builder()
					.mno(100L)
					.memoText("Update Text")
					.build();
		System.out.println(memoRepository.save(memo));
	}
	
//	 데이터베이스 멤버 변수인 Long mno 는 Primary Key 로 설정되어있다.
//	 PK를 기준으로 값을 찾는 findById 를 사용하기 위해 Long mno 변수를 초기화했다.
//	 여기서는 100 이라는 id 가 존재하는지 여부를 먼저 파악한 후 값이 데이터베이스에 있으면 
//	 값을 콘솔창에 출력하고 있다. 
	@Test
	public void testSelect() {
		Long mno = 100L;
		Optional<Memo> result = memoRepository.findById(mno);
		System.out.println("======================");
		if(result.isPresent()) {
			Memo memo = result.get();
			System.out.println(memo);
		}
	}
	
	@Test
	public void testClass() {
		System.out.println(memoRepository.getClass().getName());
		IntStream.range(0, 10).forEach(i -> System.out.println(i));
	}

	@Test
	public void testInsertDummies() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			Memo memo = Memo.builder()
					.memoText("Sample..." + i)
					.build();
			memoRepository.save(memo);
		});
	}
}
