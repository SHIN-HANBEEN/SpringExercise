package org.zerock.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer") // writer 는 외래키이므로 ToString 에서 배제해주어야 합니다.
public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    private String title;

    private String content;

    @ManyToOne (fetch = FetchType.LAZY) // 명시적으로 Lazy 로딩 지정한다.
    private Member writer; // 연관관계를 지정합니다.
}
