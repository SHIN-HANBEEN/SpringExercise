package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

// @SpringBootTest 어노테이션을 붙여야 단위테스트를 진행할 때 환경을 빌려올 수 있다.
// @SpringBootTest 어노테이션이 없으면 컨테이너 환경을 가져오지 못해서 @Autowired 로 
// 빈을 주입할 수가 없다. 
// 현재 MemoRepository 는 인터페이스인데, @Autowired 로 무엇을 넣는다는 것일까요?
// MemoRepository 인터페이스를 JPA가 JapRepository 를 상속받은 인터페이스를 만나면
// JpaRepository 를 상속받는 구현체를 만든다음 인스턴스를 만들어서 컨테이너에 갖게 됩니다. 
@SpringBootTest
public class MemoRepositoryTest {

	@Autowired
	MemoRepository memoRepository;

	// @Test 어노테이션이 있어야 JUnit 단위 테스트를 활용할 수 있다.
	@Test
	public void 피라지토리인스턴스잘가져왔는지확인() {
		System.out.println("memoRepository = " + memoRepository);
	}

	@Test
	public void 데이터등록() {
		// 키 값으로 0 을 입력한 것을 볼 수 있는데,
		// 0 값은 JPA는 이것들을 없는 것으로 판단을 한다.
		// 따라서 save 메서드를 실행시키면 모두 update 가 아니라
		// insert 를 수행하게 된다.
		Memo memo1 = new Memo(0, "새글입니다");
		Memo memo2 = new Memo(0, "새글입니다");
		Memo memo3 = new Memo(0, null);

		List<Memo> list = new ArrayList<>();
		list.add(memo1);
		list.add(memo2);
		list.add(memo3);

		memoRepository.saveAll(list);

	}

	@Test
	public void 데이터단건조회() {
		Optional<Memo> result = memoRepository.findById(1);
		if (result.isPresent()) {
			Memo memo = result.get();
			System.out.println(memo);
		}
	}

	@Test
	public void 데이터전체조회() {
		List<Memo> list = memoRepository.findAll();
		for (Memo memo : list) {
			System.out.println(memo);
		}
		// 일반형태 포문
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void 데이터수정() {
		Memo memo = new Memo(1, "글이수정되었습니다.");
		memoRepository.save(memo);
	}

	@Test
	public void 데이터삭제() {
		memoRepository.deleteById(1);
	}

	@Test
	public void 데이터전체삭제() {
		memoRepository.deleteAll();
	}
}
