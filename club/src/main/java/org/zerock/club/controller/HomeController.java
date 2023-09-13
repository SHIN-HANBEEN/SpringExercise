package org.zerock.club.controller;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.club.security.dto.ClubAuthMemberDTO;

@Controller
@Log4j2
public class HomeController {
    @GetMapping("/home/home")
    public void home() {
        log.info("home.....");
    }

}
