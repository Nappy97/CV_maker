package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.CV;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.CVDetailsDto;
import com.history.nappy.repository.cv.CVDetailsRepository;
import com.history.nappy.repository.cv.CVRepository;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CVService {

    private final CVRepository cvRepository;
    private final CVDetailsRepository cvDetailsRepository;
    private final MemberRepository memberRepository;

    // CV detail 추가
    public Long addDetail(CVDetailsDto cvDetailsDto, String username){

        Member member = memberRepository.findByUsername(username);
        CV cv = cvRepository.findByMemberId(member.getId());

        // 비어있나요?
        if (cv == null){

        }
    }
}