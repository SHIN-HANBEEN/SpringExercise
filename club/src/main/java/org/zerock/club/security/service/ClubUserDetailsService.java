package org.zerock.club.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zerock.club.entity.ClubMember;
import org.zerock.club.repository.ClubMemberRepository;
import org.zerock.club.security.dto.ClubAuthMemberDTO;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ClubUserDetailsService implements UserDetailsService { //ClubMember 가 ClugAuthMemberDTO 라는 타입으로 처리된 가장 큰 이유는 사용자의 정보를 가져오는 핵심적인 역할을 하는 UserDetailsService 라는 인터페이스 때문입니다. 스프링 시큐리티의 구조에서 인증을 담당하는 AuthenticationManager 는 내부적으로 UserDetailsService 를 호출해서 사용자의 정보를 가져옵니다. 이 코드에서 주목해서 봐야하는 점은 @Service 어노테이션을 활용하여 자동으로 스프링에서 빈으로 처리될 수 있게 되어 있다는 점과 loadUserByUserName( )에서는 별도의 처리 없이 그저 로그를 기록하고 있다는 점입니다.
    private final ClubMemberRepository clubMemberRepository; //@RequiredArgsConstructor 로 주입받는다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("ClubUserDetailsService loadUserByUsername " + username);

        Optional<ClubMember> result = clubMemberRepository.findByEmail(username, false); //username 이 실제로는 ClubMember 의 email 을 의미하므로 이를 사용해서 ClubMemberRepository 의 findByEmail( )을 호출한다. 소셜여부는 false 로 일단 진행했다.
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("Check Email or Social "); //사용자가 존재하지 않으면 UsernameNotFoundException 으로 처리
        }

        ClubMember clubMember = result.get();

        log.info("---------------");
        log.info(clubMember);

        ClubAuthMemberDTO clubAuthMemberDTO = new ClubAuthMemberDTO( //ClubMember 를 UserDetails 타입으로 처리하기 위해서 ClubAuthMemberDTO 타입으로 변환
                clubMember.getEmail(),
                clubMember.getPassword(),
                clubMember.isFromSocial(),
                clubMember.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())) //ClubMemberRole 은 스프링 시큐리티에서 사용하는 SimpleGrantedAuthority 로 변환. ROLE_ 접두어 사용
                        .collect(Collectors.toSet())
        );
        clubAuthMemberDTO.setName(clubMember.getName());
        clubAuthMemberDTO.setFromSocial(clubMember.isFromSocial());

        return clubAuthMemberDTO;
    }
}
