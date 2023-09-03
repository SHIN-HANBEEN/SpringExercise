package org.zerock.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.board.dto.ReplyDTO;
import org.zerock.board.service.ReplyService;

import java.awt.*;
import java.util.List;

@RestController //댓글 데이터를 별도의 화면 구성 없이 JSON으로 만들어 주고받으면서 처리할 것이기 때문에 @RestController 를 사용한다.
@RequestMapping("/replies/")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService; //자동주입을 위해 final 로 설정

    /* 게시물의 댓글을 가져오는 처리 */
    @GetMapping( value = "/board/{bno}", produces = MediaType.APPLICATION_JSON_VALUE ) //@RestController 는 기본적으로 모든 메서드의 리턴 타입으로 기본적으로 JSON을 사용한다.
    public ResponseEntity< List<ReplyDTO> > getListByBoard( @PathVariable("bno") Long bno ) { //메서드의 반환타입은 ResponseEntity 라는 객체를 사용하는데, 결과와 함꼐 HTTP 상태 콛를 함께 전달할 수 있다.
        log.info("bno: " + bno);
        return new ResponseEntity<>( replyService.getList(bno), HttpStatus.OK );
    }
    /* /게시물의 댓글을 가져오는 처리 */

    /* 댓글 등록 처리 */
    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO) { //@RequestBoty 어노테이션은 JSON으로 들어오는 데이터를 자동으로 해당 타입의 객체로 매핑해주는 역할을 수행한다. @RequestBody 로 request body 에 담겨 있는 ReplyDTO를 꺼낸다
        log.info(replyDTO);
        Long rno = replyService.register(replyDTO); //댓글 등록을 처리한 다음, 결과로 반환되는 댓글번호를 rno 변수에 담는다
        return new ResponseEntity<>(rno, HttpStatus.OK); //댓글 등록에 성공한 댓글번호와 HTTP 성공 코드를 반환한다.
    }
    /* /댓글 등록 처리  */

    /* 댓글 삭제 처리 */
    @DeleteMapping("/{rno}")
    public ResponseEntity<String> remove(@PathVariable("rno") Long rno) { //주소로 받은 rno 을 메서드 내에서 사용할 수 있게 받아주는 @PathVariable
        log.info("Received DELETE request for RNO: " + rno);
        replyService.remove(rno);
        log.info("Reply removed successfully.");
        return new ResponseEntity<>("success", HttpStatus.OK); //삭제에 성공하면 ResponseBody 에 "success" 란 문자를 함께 담아서 반환해준다. 해당 문자열을 확인하는 것은 view 단의 JS 코드로 처리해놓았다.
    }
    /* /댓글 삭제 처리  */

    /* 특정 게시물의 댓글 수 가져오기 */
    @GetMapping(value = "/count/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)  //댓글 개수 업데이트 담게
    public ResponseEntity<Integer> getReplyCount(@PathVariable("bno") Long bno) {
        int replyCount = replyService.getReplyCount(bno); // Modify this line to call your service method to get the reply count.
        return new ResponseEntity<>(replyCount, HttpStatus.OK);
    }
    /* /특정 게시물의 댓글 수 가져오기  */

    /* 댓글 수정 처리 */
    @PutMapping("/{rno}")
    public ResponseEntity<String> modify(@RequestBody ReplyDTO replyDTO) { //@RequestBody 는 view 단으로부터 받은 JSON 데이터를 ReplyDTO 에 맞는 형식으로 매핑시키는 역할을 수행한다. 그 결과 개발자는 JSON을 DTO로 따로 처리해줄 필요가 없고 바로 이용할 수 있게 된다.
        log.info(replyDTO);
        replyService.modify(replyDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    /* /댓글 수정 처리  */
}
