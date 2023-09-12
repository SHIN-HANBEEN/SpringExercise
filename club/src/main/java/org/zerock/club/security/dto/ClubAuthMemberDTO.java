package org.zerock.club.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Log4j2
@Getter
@Setter
@ToString
public class ClubAuthMemberDTO extends User { //UserDetails 인터페이스를 구현한 User 클래스를 상속받는다. 엔티티 클래스와 DTO 클래스를 별도로 구성했듯이 ClubAuthMemberDTO 가 바로 이런 역할을 하는 클래스입니다. ClubAuthMemeberDTO는 DTO 역할을 수행하는 클래스인 동시에 스프링 시큐리티에서 인가/인증 작업에 사용할 수 있게 됩니다.
    private String email;
    private String name;
    private boolean fromSocial;

    public ClubAuthMemberDTO(
            String username,
            String password,
            boolean fromSocial,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
        this.fromSocial = fromSocial;
    }
}
