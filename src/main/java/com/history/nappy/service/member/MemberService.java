package com.history.nappy.service.member;

import com.history.nappy.config.auth.PrincipalDetail;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.member.MemberDto;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // 회원가입
    public Long memberSave(MemberDto.RequestMemberDto dto) {
        dto.encryptPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

        Member member = dto.toEntity();
        memberRepository.save(member);
        log.info("회원 저장완료");

        return member.getId();
    }

    // id, 닉네임, 이메일 중복 여부
    @Transactional(readOnly = true)
    public boolean idCheck(String username) throws Exception {
        return memberRepository.existsByUsername(username);
    }

    @Transactional(readOnly = true)
    public String nickCheck(String nickname) throws Exception {
        boolean nicknameDuplicate = memberRepository.existsByNickname(nickname);
        if (nicknameDuplicate) {
            return "false";
        } else {
            return "true";
        }
    }

    @Transactional(readOnly = true)
    public String nickCheck2(Long id, String nickname) throws Exception {
        Member member = memberRepository.searchById(id);
        String oldNickname = member.getNickname();
        if (Objects.equals(oldNickname, nickname)) {
            return "true";
        } else {
            return "false";
        }
    }

    @Transactional(readOnly = true)
    public String emailCheck(String email) {
        boolean emailDuplicate = memberRepository.existsByEmail(email);
        if (emailDuplicate) {
            return "false";
        } else {
            return "true";
        }
    }

    @Transactional(readOnly = true)
    public String emailCheck1(Long id, String email) throws Exception {
        Member member = memberRepository.searchById(id);
        String oldEmail = member.getEmail();
        if (Objects.equals(oldEmail, email)) {
            return "true";
        } else {
            return "false";
        }
    }

    // 회원수정
    @Transactional
    public Long update(Member member, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        Member memberEntity = memberRepository.findById(member.getId()).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + member.getId()));
        memberEntity.update(bCryptPasswordEncoder.encode(member.getPassword()), member.getNickname(),
                member.getName(), member.getZipcode(), member.getAddress(), member.getDetailAddress(),
                member.getEmail());
        principalDetail.setMember(memberEntity);
        return memberEntity.getId();
    }

    @Transactional
    public Long updateOauth(Member member, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        Member memberEntity = memberRepository.findById(member.getId()).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + member.getId()));
        memberEntity.updateOauth(member.getNickname(), member.getName(), member.getZipcode(),
                member.getAddress(), member.getDetailAddress());
        principalDetail.setMember(memberEntity);
        return memberEntity.getId();
    }
}



























