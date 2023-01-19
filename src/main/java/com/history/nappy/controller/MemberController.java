package com.history.nappy.controller;

import com.history.nappy.config.auth.PrincipalDetail;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.member.MemberDto;
import com.history.nappy.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    // register
    @GetMapping("/auth/member/save")
    public String memberJoinForm() {
        return "member/joinForm";
    }

    @PostMapping("/auth/member/saveProc")
    public String saveProc(@Valid MemberDto.RequestMemberDto memberDto, BindingResult bindingResult, Model model) {

        // 검증
        if (bindingResult.hasErrors()) {
            // 회원가입 실패 시 입력 데이터 값 유지
            model.addAttribute("memberDto", memberDto);

            // 유효성 검사를 통과하지 못 한 필드와 메시지 핸들링
            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put("valid_" + error.getField(), error.getDefaultMessage());
                log.info("회원가입 실패 ! error message : " + error.getDefaultMessage());
            }

            // Model에 담아 view resolve
            for (String key : errorMap.keySet()) {
                model.addAttribute(key, errorMap.get(key));
            }

            // 회원가입 페이지로 리턴
            return "/member/joinForm";
        }

        // 성공 시
        memberService.memberSave(memberDto);
        log.info("register success");
        return "redirect:/auth/member/login";
    }

    // id 중복체크
    @RequestMapping(value = "/auth/member/saveProc/idCheck", method = RequestMethod.POST)
    @ResponseBody
    public String memberIdChkPOST(String username) throws Exception {
        boolean checkId = memberService.idCheck(username);
        if (checkId) {
            return "false";
        } else {
            return "true";
        }
    }

    // 닉네임 중복체크
    @RequestMapping(value = "/auth/member/saveProc/nicknameCheck", method = RequestMethod.POST)
    @ResponseBody
    public String memberNickChkPOST(String nickname) throws Exception {
        return memberService.nickCheck(nickname);
    }

    @RequestMapping(value = "/auth/member/modifyProc/nicknameCheck", method = RequestMethod.POST)
    @ResponseBody
    public String memberNickCheckPost(String nickname, Long id) throws Exception {
        return memberService.nickCheck2(id, nickname);
    }

    // email 중복체크
    @RequestMapping(value = "/auth/member/saveProc/emailCheck", method = RequestMethod.POST)
    @ResponseBody
    public String memberEmailChkPOST(String email) throws Exception {
        return memberService.emailCheck(email);
    }

    @RequestMapping(value = "/auth/member/modifyProc/emailCheck", method = RequestMethod.POST)
    @ResponseBody
    public String memberEmailCheckPost(String email, Long id) throws Exception {
        return memberService.emailCheck1(id, email);
    }

    // login
    @GetMapping("/auth/member/login")
    public String memberLogin(){
        return "member/loginForm";
    }

    // login fail
    @GetMapping("/auth/member/login/fail")
    public String memberLoginFail(Model model){
        model.addAttribute("loginFailMsg", "아이디 혹은 비밀번호를 확인해주세요");
        return "member/loginForm";
    }

    // modify
    @GetMapping("/member/modify")
    public String memberUpdate(@AuthenticationPrincipal PrincipalDetail principalDetail, Model model){
        model.addAttribute("principal", principalDetail.getMember());
        return "member/updateForm";
    }

    @PutMapping("/api/v1/member")
    @ResponseBody
    public Long update(@RequestBody Member member, @AuthenticationPrincipal PrincipalDetail principalDetail){
        memberService.update(member, principalDetail);
        return member.getId();
    }

    // oauth
}





























