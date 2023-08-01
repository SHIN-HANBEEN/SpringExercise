package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tbl_board")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
//lombok 이 제공하는 @Builder 를 사용하면 Test 를 할 때
//생성자를 대신해서 인스턴스를 생성하는 편리한 기능을 사용할 수 있다.
//사용할 때는 Board.Builder() 로 사용한다. 
//Builder() 뒤에 객체에 추가할 정보를 계속 이어준다. 
//Builder() 의 반환값이 Builder 이기 때문에 가능하다.
//Board board3 = Board.builder().content("내용입니다").title("3번글").build();
//위와 같이 사용이 가능한데, Builder 의 장점은 1. 생성자를 생성할 때 내가 원하는 것만 값을 넣어서
//인스턴스를 생성할 수 있게 된다. 
//Builder 의 마지막은 builder() 메서드를 사용하여 대입하는 자료형과 맞추어주어야 한다. 
//EntityListeners 는 JPA가 이벤트를 발생했을 때 감지를 할 수 있게 한다. 
//각 시스템에 현재 시간을 저장하게 해준다. @EntityListeners 를 사용하여야 
//createdDate 와 modifiedDate 를 사용할 수 있다. 
public class Board {
	// 게시판에서 글번호, 날짜, 수정날짜는 시스템이 입력하는 컬럼이다.
	// 글번호는 AutoIncrement 를 사용하면 되는데, 날짜는 어떻게할까?
	// JPA가 제공하는 기능을 사용하여야 한다.
	// @CreateDate 와 @LastModifiedDate 애노테이션을 사용해야한다.
	// 두 애노테이션 모두 @EntityListeners(AuditingEntityListener.class)와 
	// 연계하여 이벤트를 감지해서 입력을해준다.
	// 차이점이라면 @CreateDate 는 insert 할 때만 시간을 저장하고
	// @LastModifiedDate 는 insert 와 update 할 때마다 시간을 저장해준다.
	// 날짜 데이터 형식은 ISO 8601 을 기준으로 지정한다.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardNo;

	@Column(length = 30, nullable = false)
	private String title;

	@Column(length = 200)
	private String content;

	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	// LocalDateTime 은 TimeZone 을 제공합니다.
	private LocalDateTime createdDate;

	@LastModifiedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifiedDate;
}
