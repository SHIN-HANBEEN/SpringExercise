package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
		Pageable pageable = PageRequest.of(pageNum, 10, Sort.by("regDate").descending());
		// repository 를 활용해 데이터를 페이지에 담을 수 있는 객체인 pageable 객체를 만든다. 
		
		Page<Member> entityPage = repository.findAll(pageable);
		// repository 에 pageable 인스턴스를 주고 findAll 을 해서 모든 페이지를 가져온다. 
		
		Page<MemberDTO> dtoPage = entityPage.map( entity -> entityToDto(entity) );
		// 가져온 페이지는 entity 이므로 entityToDto 메서드를 활용해서 dtoPage 를 만든다. 
		
		return dtoPage;
	}
	
	@Override
	public boolean registerList(List<MemberDTO> list) { 
		for (int i = 0; i < list.size(); i++) {
			MemberDTO memberDTO = list.get(i);
			String id = memberDTO.getId();
			Optional<Member> getDto = repository.findById(id); 
			if (getDto.isPresent()) { // 해당 게시물이 존재하는지 확인
				System.out.println("사용중인 아이디입니다.");
				return false;
			}
			
			Member entity = dtoToEntity(memberDTO);
			
			// 패스워드 인코더로 패스워드 암호화하기
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashpassword = passwordEncoder.encode(entity.getPassword());
			entity.setPassword(hashpassword);
			
			repository.save(entity);		
		}
		
		return true;
	}
	
	@Override
	public boolean register(MemberDTO dto) {
		String id = dto.getId(); // 아이디 꺼내기
		
		Optional<Member> getDto = repository.findById(id); 
		if (getDto.isPresent()) { // 해당 게시물이 존재하는지 확인
			System.out.println("사용중인 아이디입니다.");
			return false;
		}
		
//		MemberDTO getDto = read(id); // 회원 상세조회
//		if(getDto != null) {
//			System.out.println("사용중인 아이디입니다.");
//			return false;
//		}
		
		Member entity = dtoToEntity(dto);
		
		// 패스워드 인코더로 패스워드 암호화하기
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashpassword = passwordEncoder.encode(entity.getPassword());
		entity.setPassword(hashpassword);
		
		repository.save(entity);		
		return true;
	}
	
	@Override
	public MemberDTO read(String id) {
		Optional<Member> result = repository.findById(id);
		
		if(result.isPresent()) {
			Member member = result.get();
			return entityToDto(member);
		} else {
			return null;
		}
	}
}
