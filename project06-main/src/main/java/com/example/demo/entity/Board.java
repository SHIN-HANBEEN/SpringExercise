package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;


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

    @Column(length = 50, nullable = false)
    private String writer; //작성자

}
