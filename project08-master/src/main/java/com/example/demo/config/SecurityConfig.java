package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 * 스프링 시큐리티 설정 클래스
 * */
@Configuration
@EnableWebSecurity //스프링 MVC와 시큐리티를 결합
public class SecurityConfig{
    
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //인증 필터 등록

		// 메뉴별 접근제한 설정
	    http.authorizeHttpRequests()
				.requestMatchers("/register").permitAll() //회원가입은 아무나 접근 가능
				.requestMatchers("/assets/*","/css/*","/js/*").permitAll() //리소스는 아무나 접근 가능
				.requestMatchers("/").authenticated() //메인화면은 로그인한 사용자이면 접근 가능
				.requestMatchers("/board/*").hasAnyRole("ADMIN","USER") //게시물 관리는 관리자 또는 사용자이면 접근 가능
				.requestMatchers("/member/*").hasRole("ADMIN"); //회원 관리는 관리자이면 접근 가능

	    http.formLogin(); //시큐리티가 제공하는 기본 로그인페이지 사용하기
        http.csrf().disable(); //csrf는 get을 제외하여 상태값을 위조(변경)할 수있는 post,put,delete 메소드를 막음
        http.logout(); // 로그아웃 처리
        
        //커스텀 로그인 페이지 적용
		http.formLogin()
		.loginPage("/customlogin")
		.loginProcessingUrl("/login")
		.permitAll();
	    
		return http.build();
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
