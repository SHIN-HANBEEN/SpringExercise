package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
// 어노테이션으로 시큐리티 설정 클래스임을 명시한다. 
// enablewebsecurity 어노테이션은 스프링 mvc 와 시큐리티를 결합한다.
public class SecurityConfig {
	
	// 사용자 인증 처리를 위한 메소드 추가
	// 메소드에 Bean 어노테이션을 붙이면 반환객체가 스프링 컨테이너의 빈으로 등록된다. 
	// 이렇게 빈으로 등록된 객체를 인증이 필요할 때 사용하게 된다. 
	// 아래 코드가 인증 필터 역할을 수행하는 메서드이다. 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 체인 형태로 기능별로 사용자 접근권한을 설정하는 코드이다.
		// 접근권한을 다 설정하면 ; 세미콜론으로 마무리 짓는다.
		http.authorizeHttpRequests()
			.requestMatchers("/register").permitAll() //회원가입은 아무나 접근 가능
			.requestMatchers("/assets/*","/css/*","/js/*").permitAll() //리소스는 아무나 접근 가능
			.requestMatchers("/").authenticated() //메인화면은 로그인한 사용자이면 접근 가능
			// board/* 로 설정하여 board 아래의 모든 주소에 대한 설정을 할 수 있다. 
			// 하나하나 설정해주지 않아도 된다.
			.requestMatchers("/board/*").hasAnyRole("ADMIN","USER") //게시물 관리는 관리자 또는 사용자이면 접근 가능
			.requestMatchers("/member/*").hasRole("ADMIN") //회원 관리는 관리자이면 접근 가능
			.requestMatchers("/register", "/idcheck").permitAll(); // 아이디 중복 체크 기능
		 
		// 개발자가 별도로 로그인 페이지를 만들지 않았을 경우
		// 시큐리티가 제공하는 로그인 창을 쓰겠다는 코드다.
//		http.formLogin(); //시큐리티가 제공하는 기본 로그인페이지 사용하기
		
		/* 
		  커스텀 로그인 페이지 적용한다.
		  home 컨트롤러에 새로운 메서드를 추가해주어야 한다.
		*/
		http.formLogin()
			.loginPage("/customlogin")
			.loginProcessingUrl("/login")
			.permitAll();
		
		//csrf 는 사이트의 공격을 막기 위해서 post 요청을 막아놓습니다.
		// 그런데 우리는 post 를 사용했었는데요.
		// post 를 사용할 수 있도록 csrf 를 사용할 수 있도록 만듭니다.
		http.csrf().disable(); //csrf는 get을 제외하여 상태값을 위조(변경)할 수있는 post,put,delete 메소드를 막음
			
		// 로그아웃 기능을 위해서 HttpSecurity 의 logout 메소드를 추가해준다. 
		http.logout();
		
		// HttpSecurity 는 builder 를 가지고 있다. 
		// 필요한 설정들을 해준 다음 리턴을 해주면 된다.
		return http.build();
	}
	
	// 사용자는 비밀번호를 1234 와 같은 형식으로 입력을 하는데
	// 실제 데이터베이스에 저장되어 있는 비밀번호는 해시코드로 저장이 되어 있습니다. 
	// 따라서 해시코드와 사용자가 입력한 값을 해시코드로 변환시켜주는 역할을 수행해야 하는데,
	// 그 역할을 수행하는 것이 PasswordEncoder 입니다. 
	// 패스워드 암호화할 때 사용한 암호화 방식인 bcrypt 와 똑같은 것을 
	// 반환시켜준 것을 볼 수 있습니다. 
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
