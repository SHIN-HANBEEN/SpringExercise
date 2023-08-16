package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {
	private String id;
	private String password;
	private String name;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	// 회원 등급 추가
	private String role;
}
