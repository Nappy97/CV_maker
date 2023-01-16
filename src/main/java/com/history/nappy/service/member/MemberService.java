package com.history.nappy.service.member;

import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.member.MemberDto;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 회원가입
    public Long memberSave(MemberDto.RequestMemberDto dto){
        dto.encryptPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

        Member member = dto.toEntity();
        memberRepository.save(member);
        log.info("회원 저장완료");

        return member.getId();
    }

    // id, 닉네임, 이메일 중복 여부
//    @Transactional(readOnly = true)
//    public boolean idCheck(String username) throws Exception{
//        return memberRepository.ex
//    }
}
