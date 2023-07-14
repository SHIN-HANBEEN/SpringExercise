package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

// repository 는 인터페이스인데, 같은 인터페이스인 JpaRepository 를 상속받는 
// 것만 해도 Spring 이 알아서 필요한 코드를 생성해주는 놀라운 일이 벌어진다. 
// 또한 JpaRepository 를 상속을 하면서 자동으로 MemoRepository 가 컨테이너에 저장된다. 
public interface MemoRepository extends JpaRepository<Memo, Long> {

}
