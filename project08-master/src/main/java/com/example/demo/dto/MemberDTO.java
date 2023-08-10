package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

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
    private String role; //사용자 등급 추가 (사용자:ROLE_USER, 관리자:ROLE_ADMIN)

}
