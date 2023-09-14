package org.zerock.club.security.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.zerock.club.entity.ClubMember;
import org.zerock.club.entity.ClubMemberRole;
import org.zerock.club.repository.ClubMemberRepository;
import org.zerock.club.security.dto.ClubAuthMemberDTO;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class ClubOAuth2UserDetailsService extends DefaultOAuth2UserService { //소셜 로그인 과정에서 동작하는 OAuth2UserService 인터페이스의 구현체인 DefaultOAuth2UserService 클래스를 상속받는다.
    private final ClubMemberRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException { //ClubOAuth2UserDetailsService 동작여부 확인하는 코드
        log.info("--------------------");
        log.info("userRequest: " + userRequest); //org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest 객체

        String clientName = userRequest.getClientRegistration().getClientName();

        log.info("clientName: " + clientName); //Google 로 출력된다
        log.info(userRequest.getAdditionalParameters());

        OAuth2User oAuth2User = super.loadUser(userRequest);

        log.info("=========================");
        oAuth2User.getAttributes().forEach((k,v) -> {
            log.info(k + ":" + v); //sub, piture, email, email_verified, EMAIL 등이 출력된다
        });

        String email = null;

        if(clientName.equals("Google")) { //구글을 이용하는 경우
            email = oAuth2User.getAttribute("email"); //OAuth2User 의 getAttribute( )를 이용해서 이메일 정보를 추출하고 있다.
        }

        log.info("EMAIL: " + email);

//        ClubMember member = saveSocilMember(email);
//
//        return oAuth2User;

        ClubMember member = saveSocialMember(email);

        ClubAuthMemberDTO clubAuthMember = new ClubAuthMemberDTO(
                                    member.getEmail(),
                                    member.getPassword(),
                                    true, //fromSocial
                                    member.getRoleSet().stream().map(
                                            role -> new SimpleGrantedAuthority("ROLE_" + role.name())
                                    ).collect(Collectors.toList()),
                                    oAuth2User.getAttributes() //OAuth2User 의 모든 데이터는 ClubAuthMemberDTO의 내부로 전달해서 필요한 순간에 사용할 수 있도록 합니다.
        );

        clubAuthMember.setName(member.getName());

        return clubAuthMember;
    }

    private ClubMember saveSocialMember(String email) {
        Optional<ClubMember> result = repository.findByEmail(email, true); //소셜 로그인한 사람의 이메일이 기존에 이미 가입되어 있있는지 여부 확인

        if (result.isPresent()) {
            return result.get();
        }

        ClubMember clubMember = ClubMember.builder().email(email) //기존 회원 가입을 하지 않은 소셜 로그인이라면 패스워드는 1111로, name 은 그냥 이메일 그대로 설정
                .name(email)
                .password("1111")
                .fromSocial(true)
                .build();
        clubMember.addMemberRole(ClubMemberRole.USER);

        repository.save(clubMember);

        return clubMember;
    }
}
