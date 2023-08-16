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
@EnableWebSecurity
public class SecurityConfig{
    
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http.authorizeHttpRequests()
				.requestMatchers("/register","/idcheck").permitAll() //아이디중복체크 경로 추가 
				.requestMatchers("/assets/*","/css/*","/js/*").permitAll()
				.requestMatchers("/").authenticated()
				.requestMatchers("/board/*").hasAnyRole("ADMIN","USER")
				.requestMatchers("/member/*").hasRole("ADMIN");

        http.csrf().disable();
        
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
