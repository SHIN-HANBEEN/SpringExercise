package org.zerock.board.service;

import org.zerock.board.dto.ReplyDTO;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;

import java.util.List;

public interface ReplyService {
    Long register(ReplyDTO replyDTO); //댓글의 등록
    List<ReplyDTO> getList(Long bno); //특정 게시물의 댓글 목록가져오기
    void modify(ReplyDTO replyDTO); //댓글 수정
    void remove(Long rno); //댓글 삭제

    default Reply dtoToEntity(ReplyDTO replyDTO) { //ReplyDTO를 Reply 엔티티로 변환할 때는 연관관계에 의해 Board 객체의 처리가 함께 진행됨.
        Board board = Board.builder().bno(replyDTO.getBno()).build();
        Reply reply = Reply.builder()
                .rno(replyDTO.getRno())
                .text(replyDTO.getText())
                .replyer(replyDTO.getReplyer())
                .board(board)
                .build();
        return reply;
    }

    default ReplyDTO entityToDTO(Reply reply) { //Reply 객체를 ReplyDTO로 변환할 때는 Board 객체가 필요하지 않으므로 게시물 번호만 가져가도록 처리한다
        ReplyDTO replyDTO = ReplyDTO.builder()
                .rno(reply.getRno())
                .text(reply.getText())
                .replyer(reply.getReplyer())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();
        return replyDTO;
    }
}
