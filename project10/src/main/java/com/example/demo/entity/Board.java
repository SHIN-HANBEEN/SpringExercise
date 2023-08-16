package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder //생성자와 같이 객체를 생성하는 메소드를 추가. 생성자와 달리 필요한 값만 입력할 수 있음
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no; //글번호

    @Column(length = 100, nullable = false)
    private String title; //제목

    @Column(length = 1500, nullable = false)
    private String content; //내용

    @ManyToOne
    private Member writer; //작성자
    // 자료형을 String 에서 Member 로 바꾸면 JPA가 외래키임을 인식하게된다. 
    // 또한 @ManyToOne 애노테이션을 추가해준다. Board 테이블을 삭제한다음 다시 생성하면
    // 다대일 관계가 생긴다. 

}
