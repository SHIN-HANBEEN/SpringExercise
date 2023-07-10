package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * 데이터베이스의 테이블 구조를 정의하는 클래스
 * */

@Entity //엔티티 클래스임을 명시
@Table(name="tbl_memo") //테이블 이름. 생략하면 클래스 이름과 동일한 이름으로 생성됨
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Memo {
	
	@Id //PK 지정. 엔티티는 PK를 필수로 가져야함
	@GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 방식. NULL값이면 자동 증가한 값 입력
	private int no;
	
	@Column(length = 200, nullable = true) //일반 컬럼 지정 (크기, 제약사항)
	private String text; //타입과 이름
}
