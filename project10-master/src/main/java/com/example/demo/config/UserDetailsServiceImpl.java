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
 * */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private MemberService service;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		System.out.println("login id : " + userName);
		MemberDTO dto = service.read(userName);
		if(dto == null) {
			throw new UsernameNotFoundException("");
		} else {
			return new CustomUser(dto);
		}
			
	}

}
