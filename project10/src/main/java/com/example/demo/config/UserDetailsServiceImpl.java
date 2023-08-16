package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomUser;
import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;

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
			// 시큐리티 컨테이너가 받아가고, 내부적으로 필요할 때마다 꺼내서 사용하게 됩니다. 
			// 시큐리티는 내부적으로 처리되는게 많아서 동작 과정을 이해하기가 어렵습니다.
			// 로그인을 하면 브라우저는 세션이라는 쿠키를 갖게 됩니다. 로그아웃을 하기 전까지 계속 갖게됩니다.
			// 사용자가 요청을 하면 그 요청 처리를 위한 상태를 유지하고 있게 되고, 요청을 할 때마다 로그인을 할 필요가 없습니다.
			// 한번 로그인을 하면 로그아웃을 하지 않는 이상 로그인정보가 유지됩니다. 
			// 로그인을 하면 'JSESSIONID' 라는 쿠키가 생성되는데요. 
			// 로그인 한 다음 브라우저의 Application 탭의 Cookies 에서 확인할 수 있습니다. 
			// 이 쿠키 를 사용자가 요청을 보낼 때 마다 사용하여 로그인 인증을 하게됩니다. 
			// 실제로 다른 페이지를 누른다음 네트워크 헤더를 보면 Cookie 에 JSESSIONID 가 들어있는 것을 확인할 수 있습니다. 
		}
			
	}
}
