package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository repository;

	@Override
	public Page<MemberDTO> getList(int page) {
		int pageNum = (page == 0) ? 0 : page -1; //page index는 0부터 시작
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("id").descending());
		// repository 를 활용해 데이터를 페이지에 담을 수 있는 객체인 pageable 객체를 만든다. 
		
		Page<Member> entityPage = repository.findAll(pageable);
		// repository 에 pageable 인스턴스를 주고 findAll 을 해서 모든 페이지를 가져온다. 
		
		Page<MemberDTO> dtoPage = entityPage.map( entity -> entityToDto(entity) );
		// 가져온 페이지는 entity 이므로 entityToDto 메서드를 활용해서 dtoPage 를 만든다. 
		
		return dtoPage;
	}
	
	
}
