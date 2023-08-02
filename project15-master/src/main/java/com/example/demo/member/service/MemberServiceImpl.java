package com.example.demo.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.member.domain.MemberDto;
import com.example.demo.member.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;

	@Override
	public MemberDto register(MemberDto dto) {
		// 아이디 중복 체크
		String id = dto.getId();
		MemberDto getDto = get(id);
		if (getDto != null) {
			log.info("아이디가 중복됩니다");
			log.info("사용자를 추가할수 없습니다");
			return null;
		}
		// 비밀번호 암호화 로직추가
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = passwordEncoder.encode(dto.getPassword());
		dto.setPassword(password);
		
		/* 등록일과 수정일을 현재시간으로 저장하는 코드 삭제 */
		log.info("register......" + dto);
		int result = mapper.insert(dto);

		/* 추가에 성공했으면 다시 조회하여 도메인을 반환한다 */		
		if(result==1) {
			MemberDto insertDto = mapper.select(id);
			return insertDto;
		} else {
			return null;
		}
	}

	@Override
	public List<MemberDto> getList() {
		log.info("get List......");
		return mapper.selectList();
	}

	@Override
	public MemberDto get(String id) {
		log.info("get......" + id);
		return mapper.select(id);
	}

	@Override
	public boolean modify(MemberDto dto) {
		MemberDto readDto = mapper.select(dto.getId());
		if (readDto == null) {
			log.info("해당 회원은 존재하지않습니다.");
			return false;
		} else {
			/* 수정일를 현재시간으로 저장하는 코드 삭제 */
			log.info("modify......" + dto);
			return mapper.update(dto) == 1;
		}
	}

	@Override
	public boolean remove(String id) {
		MemberDto readDto = mapper.select(id);
		if (readDto == null) {
			log.info("해당 회원은 존재하지않습니다.");
			return false;
		} else {
			log.info("remove...." + id);
			return mapper.delete(id) == 1;
		}
	}

}
