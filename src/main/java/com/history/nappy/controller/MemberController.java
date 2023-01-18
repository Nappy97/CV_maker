package com.history.nappy.controller;

import com.history.nappy.dto.member.MemberDto;
import com.history.nappy.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // register
    @GetMapping("/auth/member/save")
    public String memberJoinForm(){
        return "member/joinForm";
    }

    @PostMapping("/auth/member/saveProc")
    public String saveProc(@Valid MemberDto.RequestMemberDto memberDto, BindingResult bindingResult, Model model){

        // 검증
        if (bindingResult.hasErrors()){
            // 회원가입 실패 시 입력 데이터 값 유지
            model.addAttribute("memberDto", memberDto);

            // 유효성 검사를 통과하지 못 한 필드와 메시지 핸들링

        }
    }
}
