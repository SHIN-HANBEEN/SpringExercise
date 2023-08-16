package org.zerock.ex3.dto;

import lombok.*;

import java.time.LocalDateTime;

// @Data 는 Getter/Setter, toString()
// @equalsAndHashCode 를 자동으로 생성합니다.
// @Setter 사용은 지양해야 하므로
// @Data 를 사용하지 않겠습니다.
@Getter
@ToString
@EqualsAndHashCode
public class SampleDTO {
    private Long sno;
    private String first;
    private String last;
    private LocalDateTime regTime;

    // Setter 를 삭제한 대신 생성자에서만 초기화를 진행하게끔 만들어준다.
    @Builder
    private SampleDTO(Long sno, String first, String last, LocalDateTime regTime) {
        this.sno = sno;
        this.first = first;
        this.last = last;
        this.regTime = regTime;
    }
}

