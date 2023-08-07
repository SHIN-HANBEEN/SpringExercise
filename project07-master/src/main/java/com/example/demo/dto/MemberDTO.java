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
    
}
