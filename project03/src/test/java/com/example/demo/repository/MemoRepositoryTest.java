package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest {
	@Autowired
	MemoRepository memoRepository;	
	
	@Test
	public void 리퍼지토리인스턴스를가져왔는지확인() {
		System.out.println("memoRepository = " + memoRepository);
	}
	
	@Test
	public void 데이터등록() {
		Memo memo1 = new Memo(0, "새글입니다");
		memoRepository.save(memo1); // Insert
		Memo memo2 = new Memo(0, "새글입니다");
		memoRepository.save(memo2); // Insert
		Memo memo3 = new Memo(0, null);
		memoRepository.save(memo3); // Insert
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Memo> result = memoRepository.findById(1); // 키 값으로 조회. 조회결과를 optional로 반환
		if(result.isPresent()) { // 값이 있는지 확인
			Memo memo = result.get();
			System.out.println(memo);
		}
	}
	
	@Test
	public void 데이터전체조회() {
		List<Memo> list = memoRepository.findAll(); //전체 목록은 리스트로 반환
		for(Memo memo : list) {
			System.out.println(memo);
		}
	}
	
	@Test
	public void 데이터수정() {
		Memo memo = new Memo(1,"글이수정되었습니다"); //1번 메모의 내용 변경
		memoRepository.save(memo);	//데이터 추가,수정 모두 save 함수를 사용함
	}
	
	@Test
	public void 데이터삭제() {
		memoRepository.deleteById(1); //1번 메모가 없으면, DataAccessException 에러가 발생함
	}
	
	@Test
	public void 데이터전체삭제() {
		memoRepository.deleteAll();
	}
}
