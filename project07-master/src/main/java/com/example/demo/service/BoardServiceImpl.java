package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository repository;

	@Override
	public int register(BoardDTO dto) {
		Board entity = dtoToEntity(dto);
		repository.save(entity);

		return entity.getNo();
	}

	/* 목록조회 메소드 변경 */
	@Override
	public Page<BoardDTO> getList(int page) { //페이지 번호 받기
		int pageNum = (page == 0) ? 0 : page - 1; // page는 index 처럼 0부터 시작.
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("no").descending()); //페이지번호, 게시물개수, 정렬방법을 입력하여 페이지 객체 만들기
		Page<Board> entityPage = repository.findAll(pageable); //게시물 목록을 페이지에 담아서 조회하기
		Page<BoardDTO> dtoPage = entityPage.map( entity -> entityToDto(entity) ); //엔티티 타입의 페이지를 DTO 타입으로 변환

		return dtoPage;
	}

	@Override
	public BoardDTO read(int no) {
        Optional<Board> result = repository.findById(no);
        if(result.isPresent()) {
        	Board board =  result.get();
        	return entityToDto(board);
        } else {
        	return null;
        }
	}

	@Override
	public void modify(BoardDTO dto) {
        Optional<Board> result = repository.findById(dto.getNo());
        if(result.isPresent()){
            Board entity = result.get();
            entity.setTitle(dto.getTitle());
            entity.setContent(dto.getContent());
            repository.save(entity);
        }
	}

	@Override
	public void remove(int no) {
		repository.deleteById(no);
	}

}
