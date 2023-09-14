package org.zerock.club.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.zerock.club.security.handler.ClubLoginSuccessHandler;
import org.zerock.club.security.service.ClubUserDetailsService;

@Configuration
@EnableWebSecurity
@Log4j2
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {
    @Autowired
    private ClubUserDetailsService clubUserDetailsService; //Remember Me 에서 사용

    @Bean
    PasswordEncoder passwordEncoder() { //시큐리티 커스터마이징 첫 설정은 패스워드 암호화 입니다.
        return new BCryptPasswordEncoder(); //Security 커스터마이징의 첫 번째 처리는 비밀번호 암호화 방식의 설정인데, BCryptPasswordEncooder 를 최근에는 많이 사용하고 있는 추세이다.
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //url 주소마다 접근 설정 처리. SecurityFilterChain 을 반환하는 코드입니다.
        log.info("----------filterchain--------------");

//        http.authorizeHttpRequests()
//                .requestMatchers("/sample/all").permitAll()
//                .requestMatchers("/sample/member").hasRole("USER");

        http.formLogin(); //인가/인증 필요할 때 로그인 화면을 띄워준다.
        http.csrf().disable(); //CSRF 토큰 발행을 중단시킨다. 보안상 이슈가 있어서 그렇다.
        http.logout();
        http.oauth2Login().successHandler(clubLoginSuccessHandler()); //google 로그인 처럼 OAuth 로그인을 위한 설정
        http.rememberMe().tokenValiditySeconds(60*60*24*7) //Remember Me 활성화
                .userDetailsService(clubUserDetailsService);

        return http.build();
    }

    @Bean
    public ClubLoginSuccessHandler clubLoginSuccessHandler() {
        return new ClubLoginSuccessHandler(passwordEncoder());
    }

    //ClubUserDetailsService 를 구현하면서 더 이상 사용하지 않습니다.
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() { //암호화 테스트를 위한 코드입니다. 암호화된 패스워드를 이용하기 위해서는 해당 암호를 사용하는 사용자가 필요한데요. 아래와 같은 코드로 사용자를 생성해줄 수 있습니다.
//        UserDetails user = User.builder() //시큐리티가 기본적으로 제공하는 User 구현체를 이용해서 테스트를 위한 임의의 사용자를 생성할 수 있다.
//                .username("user1")
//                .password(passwordEncoder().encode("1111"))
//                .roles("USER")
//                .build();
//
//        log.info("userDetailsService......");
//        log.info(user);
//
//        return new InMemoryUserDetailsManager(user); //생성한 임의의 유저를 InMemoryUserDetailsManager( ) 를 활용해서 메모리 상에 있는 데이터를 이용하는 인증 매니저(AuthenticationManager)를 생성합니다.
//    }

    //deprecated 된 코드는 주석처리하였다.


//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/sample/all").permitAll()
//                                .requestMatchers("/sample/member").hasRole("USER")
//                )
//                .formLogin();
//        http
//                .csrf().disable()
//                .logout()
//                .and()
//                .oauth2Login();
//
//        return http.build();
//    }
}


