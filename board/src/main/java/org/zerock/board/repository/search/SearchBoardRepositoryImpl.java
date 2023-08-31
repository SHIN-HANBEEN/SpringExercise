package org.zerock.board.repository.search;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import lombok.extern.log4j.Log4j2;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.QBoard;



import java.util.List;

@Log4j2
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository{
    public SearchBoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public Board search1() {
        log.info("search1............");

        QBoard board = QBoard.board;//Q 도메인 클래스 준비
        JPQLQuery<Board> jpqlQuery = from(board);//JPQLQuery 준비(Querydsl 은 JPQLQuery 인터페이스를 갖고 있다)
        jpqlQuery.select(board).where(board.bno.eq(1L)); //SQL문 생성

        log.info("-------------");
        log.info(jpqlQuery);
        log.info("-------------");

        List<Board> result = jpqlQuery.fetch();

        return null;
    }
}
