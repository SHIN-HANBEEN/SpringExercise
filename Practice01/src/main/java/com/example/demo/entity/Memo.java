package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // 엔티티 클래스임을 명시; 해당 클래스를 JPA가 관리하도록 함
@Table(name = "tbl_memo") // 해당 엔티티와 실제 DB에 들어가는 이름이 다를 경우 사용하는 애노테이션
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Memo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;

	@Column(length = 200, nullable = true)
	private String text;
}
