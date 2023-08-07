package com.example.demo.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@Service // 비즈니스 로직을 처리하는 역할을 명시
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository repository; // 사용할 리파지토리를 멤버로 선언

	@Override
	public int register(BoardDTO dto) {
		Board entity = dtoToEntity(dto); // 컨트롤러에서 전달받은 dto를 엔티티로 변환
		repository.save(entity); // 리파티토리에 엔티티를 전달하여 저장

		return entity.getNo(); // 새로 등록된 게시물의 번호를 반환
	}

//	@Override
//	public List<BoardDTO> getList() {
//		List<Board> result = repository.findAll(); // 데이터베이스에서 게시물 목록을 가져온다
//		List<BoardDTO> list = new ArrayList<>();
//		list = result.stream() // 리스트에서 스트림 생성
//				.map(entity -> entityToDto(entity)) // 중간연산으로 엔티티를 dto로 변환
//				.collect(Collectors.toList()); // 최종연산으로 결과를 리스트로 변환
//
//		return list; // 화면에 필요한 dto 리스트 반환
//	}

	// 목록조회 메소드 변경
	@Override
	public Page<BoardDTO> getList(int page) { // 컨트롤러를 통해서 페이지 번호를 수집한다. 
		int pageNum = (page==0) ? 0 : page-1; // page index 는 0 부터 시작합니다. 그래서 컨트롤러에서 수집한 값이 1이라면 -1을한다.
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("no").descending());
		Page<Board> entityPage = repository.findAll(pageable); // 게시물 목록을 페이지에 담아서 가져온다. 
		// 페이지 객체는 조건 + 게시물목록 으로 이루어져 있어서, 우리가 필요한 조건 혹은 게시물을 꺼내서 쓸 수 있다. 
		Page<BoardDTO> dtoPage = entityPage.map( entity -> entityToDto(entity) );
		// Service 가 ENtity 를 DTO 로 정보 교환을 하여 우리가 사용하게 된다. 
		
		return dtoPage;
	}
	
	@Override
	public BoardDTO read(int no) {

		Optional<Board> result = repository.findById(no);

		if (result.isPresent()) {
			Board board = result.get();
			return entityToDto(board);
		} else {
			return null;
		}
	}

	@Override
	public void modify(BoardDTO dto) {
		// 업데이트 하는 항목은 '제목', '내용'
		Optional<Board> result = repository.findById(dto.getNo());
		if (result.isPresent()) { // 해당 게시물이 존재하는지 확인
			Board entity = result.get();

			entity.setTitle(dto.getTitle());
			entity.setContent(dto.getContent());

			repository.save(entity);
		}

	}

	@Override
	public int remove(int no) {

		Optional<Board> result = repository.findById(no);
		
		if (result.isPresent()) {
			repository.deleteById(no);
			return 1; //성공
		}else {
			return 0; //실패
		}
		
	}

}
