package com.example.demo.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class BoardDTO {

	@Schema(description = "글번호")
	// swagger에서 데이터 모델을 정의하고 설명해줄 때 사용합니다. 
    private int no;
	
	@Schema(description = "제목")
	// swagger에서 데이터 모델을 정의하고 설명해줄 때 사용합니다. 
    private String title;
	
	@Schema(description = "내용")
	// swagger에서 데이터 모델을 정의하고 설명해줄 때 사용합니다. 
    private String content;
	
	@Schema(description = "작성자")
	// swagger에서 데이터 모델을 정의하고 설명해줄 때 사용합니다. 
    private String writer;
	
	@Schema(description = "등록일")
	// swagger에서 데이터 모델을 정의하고 설명해줄 때 사용합니다. 
    private LocalDateTime regDate;
	
	@Schema(description = "수정일")
	// swagger에서 데이터 모델을 정의하고 설명해줄 때 사용합니다. 
    private LocalDateTime modDate;
}
