package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {

	@Schema(description = "글번호")
    private int no;
	
	@Schema(description = "제목")
    private String title;
	
	@Schema(description = "내용")
    private String content;
	
	@Schema(description = "작성자")
    private String writer;
	
	@Schema(description = "등록일")
    private LocalDateTime regDate;
	
	@Schema(description = "수정일")
    private LocalDateTime modDate;
}
