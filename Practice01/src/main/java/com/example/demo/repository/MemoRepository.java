package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

// 인터페이스에서 인터페이스를 상속받으면 extend 를 사용한다.
// JpaRepository 는 첫번째 인자는 엔티티 두번째 인자는 엔티티의 PK 자료형인데 int 는 wrapper 클래스
// 인 Integer 를 사용하고 있다.
// 이렇게 Memo 엔티티를 처리할 수 있는 CRUD 메서드들을 물려받은 것이다.
public interface MemoRepository extends JpaRepository<Memo, Integer> {

}
