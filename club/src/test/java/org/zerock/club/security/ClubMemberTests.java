package org.zerock.club.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.zerock.club.entity.ClubMember;
import org.zerock.club.entity.ClubMemberRole;
import org.zerock.club.repository.ClubMemberRepository;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class ClubMemberTests {
    @Autowired
    private ClubMemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummies() {
        //1 - 100까지는 USER만 지정
        //81 - 100까지는 USER, MANAGER 지정
        //91 - 100까지는 USER, MANAGER, ADMIN 지정

        IntStream.rangeClosed(1, 100).forEach(i -> {
            ClubMember clubMember = ClubMember.builder()
                    .email("user" + i + "@zerock.org")
                    .name("사용자" + i)
                    .fromSocial(false)
                    .password(passwordEncoder.encode("1111"))
                    .build();
            clubMember.addMemberRole(ClubMemberRole.USER); //전체 사용자는 USER 등급 포함
            if(i > 80) {
                clubMember.addMemberRole(ClubMemberRole.MANAGER); //80~90번 사용자는 MANAGER 등급 추가
            }
            if(i > 90) {
                clubMember.addMemberRole(ClubMemberRole.ADMIN); //90~100번 사용자는 ADMIN 등급 추가
            }
            repository.save(clubMember);
        });
    }

    @Test
    public void testRead() {
        Optional<ClubMember> result = repository.findByEmail("user95@zerock.org", false);
        ClubMember clubMember = result.get();
        System.out.println(clubMember);
    }
}
