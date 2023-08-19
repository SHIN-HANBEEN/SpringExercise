package org.zerock.guestbook.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
// 강의에서는 @Data 를 이용하는데 뭐가 사용되는지 명확히 보기 위해서 하나씩 작성합니다.
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class GuestbookDTO {
    private Long gno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate, modDate;
}
