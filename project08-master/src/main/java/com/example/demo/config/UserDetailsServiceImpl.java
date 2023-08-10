package com.example.demo.config;


import com.example.demo.dto.CustomUser;
import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/*
 * 사용자 커스텀 로그인 인증 서비스
 * loadUserByUsername를 오버라이드 하여 사용자 정보를 조회하고 인증객체를 생성한다
 * 유저 인증서비스는 provider에 등록한다
 * */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MemberService service;

	@Override
	public UserDetails loadUserByUsername(String userName) { // userName는 아이디를 의미
		System.out.println("login id : " + userName);
		MemberDTO dto = service.read(userName);
		if(dto == null) {
			throw new UsernameNotFoundException(""); //사용자가 존재하지 않을때 에러를 발생시킴
		} else {
			return new CustomUser(dto); //사용자도메인을 시큐리티 인증객체로 변환
		}
			
	}

}
