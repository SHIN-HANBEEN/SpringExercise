package org.zerock.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.board.dto.ReplyDTO;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;
import org.zerock.board.repository.ReplyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;

    @Override
    public Long register(ReplyDTO replyDTO) {
        Reply reply = dtoToEntity(replyDTO);
        replyRepository.save(reply);
        return reply.getRno();
    }

    @Override
    public List<ReplyDTO> getList(Long bno) {
        List<Reply> result = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(bno).build());
        return result.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        Long rno = replyDTO.getRno(); //댓글을 수정할 때는 바로 save 를 시키면 새로운 댓글을 생성하는 문제를 발생시킨다. replydto 로부터 rno 를 받아서 rno 로 DB에서 꺼내와서 작업을 진행해야 한다.
        Reply existingReply = replyRepository.findById(rno)
                .orElseThrow(() -> new IllegalArgumentException("Reply with rno " + rno + " not found"));

        existingReply.setText(replyDTO.getText());

        // Save the updated reply to the repository.
        replyRepository.save(existingReply);
    }

    @Override
    public void remove(Long rno) {
        replyRepository.deleteById(rno);
    }

    @Override
    public int getReplyCount(Long bno) { //게시물의 댓글 수 가져오기
        // Implement the logic to retrieve the reply count for the given bno (board/article).
        // You can use your data access layer or repository to fetch this count.
        int replyCount = replyRepository.getReplyCountByBno(bno); // Modify this line based on your repository method.
        return replyCount;
    }
}
