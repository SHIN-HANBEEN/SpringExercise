package com.example.demo.board.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.domain.BoardDto;
import com.example.demo.board.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	@Override 
	public BoardDto register(BoardDto dto) { /* 게시물 등록 후 새로운 글번호 가져오기 */
		log.info("register......" + dto);		
		mapper.insert(dto);
		int newNo = dto.getNo();
		BoardDto newDto = get(newNo);
		return newDto;
	}

	@Override
	public List<BoardDto> getList() {
		log.info("get List......");
		return mapper.selectList();
	}

	@Override
	public BoardDto get(int no) {
		log.info("get......" + no);
		return mapper.select(no);
	}

	@Override
	public boolean modify(BoardDto dto) {
		BoardDto readDto = mapper.select(dto.getNo());
		if (readDto == null) {
			log.info("해당 게시물은 존재하지않습니다.");
			return false;
		} else {
			/* 수정일를 현재시간으로 저장하는 코드 삭제 */
			log.info("modify......" + dto);
			return mapper.update(dto) == 1;
		}
	}

	@Override
	public boolean remove(int no) {
		BoardDto readDto = mapper.select(no);
		if (readDto == null) {
			log.info("해당 게시물은 존재하지않습니다.");
			return false;
		} else {
			log.info("remove...." + no);
			return mapper.delete(no) == 1;
		}
	}

}
