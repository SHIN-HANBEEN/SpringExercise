package org.zerock.club.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@Log4j2
public class SecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); //Security 커스터마이징의 첫 번째 처리는 비밀번호 암호화 방식의 설정인데, BCryptPasswordEncooder 를 최근에는 많이 사용하고 있는 추세이다.
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() { //암호화 테스트를 위한 코드입니다. 암호화된 패스워드를 이용하기 위해서는 해당 암호를 사용하는 사용자가 필요한데요. 아래와 같은 코드로 사용자를 생성해줄 수 있습니다.
        UserDetails user = User.builder() //시큐리티가 기본적으로 제공하는 User 구현체를 이용해서 테스트를 위한 임의의 사용자를 생성할 수 있다.
                .username("user1")
                .password(passwordEncoder().encode("1111"))
                .roles("USER")
                .build();

        log.info("userDetailsService......");
        log.info(user);

        return new InMemoryUserDetailsManager(user); //생성한 임의의 유저를 InMemoryUserDetailsManager( ) 를 활용해서 메모리 상에 있는 데이터를 이용하는 인증 매니저(AuthenticationManager)를 생성합니다.
    }
}
