package org.koreait.controllers.members;

import jakarta.persistence.EntityManager;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.koreait.commons.MemberUtil;
import org.koreait.commons.Utils;
import org.koreait.entities.BoardData;
import org.koreait.entities.Member;
import org.koreait.models.member.MemberInfo;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Transactional
public class MemberController {

    private final MemberUtil memberUtil;
    private final Utils utils;
    private final EntityManager em;

    @GetMapping("/join")
    public String join() {
        return utils.tpl("member/join");
    }

    @GetMapping("/login")
    public String login(String redirectURL, Model model) {
        model.addAttribute("redirectURL", redirectURL);
        return utils.tpl("member/login");
    }


    @ResponseBody
    @GetMapping("/info")
    public void info() {
        BoardData data = BoardData.builder()
                .subject("제목")
                .content("내용")
                .build();

        em.persist(data);
        em.flush();

        data.setSubject("(수정)제목");
        em.flush();
    }
}


        /*
        Member member = memberUtil.getMember();
        if (memberUtil.isLogin()) {
            log.info(member.toString());
        }

        log.info("로그인 여부 : {}", memberUtil.isLogin());

    }


    public void info() {
        MemberInfo member = (MemberInfo)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();

        log.info(member.toString());

    }

    public void info(@AuthenticationPrincipal MemberInfo memberInfo) {
        log.info(memberInfo.toString());
    }

    public void info(Principal principal) {
        String email = principal.getName();
        log.info(email);
    }
     */

