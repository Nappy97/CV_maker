package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.details.CVDetails;
import com.history.nappy.domain.cv.details.CVDetailsList;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.details.CVDetailsDto;
import com.history.nappy.dto.cv.details.CVDetailsListDto;
import com.history.nappy.repository.cv.details.CVDetailsListRepository;
import com.history.nappy.repository.cv.details.CVDetailsRepository;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CVDetailsService {

    private final CVDetailsRepository cvDetailsRepository;
    private final CVDetailsListRepository cvDetailsListRepository;
    private final MemberRepository memberRepository;

    // 디테일 저장
    public Long saveCVDetails(CVDetailsDto cvDetailsDto, String username) {

        Member member = memberRepository.findByUsername(username);
        CVDetailsList cvDetailsList = cvDetailsListRepository.findByMemberId(member.getId());

        if (cvDetailsList == null) {
            cvDetailsList = CVDetailsList.createCVDetailsList(member);
            cvDetailsListRepository.save(cvDetailsList);
        }

        CVDetails cvDetails;
        cvDetails = CVDetails.createCVDetails(cvDetailsList, cvDetailsDto.getTitle(), cvDetailsDto.getContent());
        cvDetailsRepository.save(cvDetails);

        return cvDetails.getId();
    }

    // 목록 조회
    @Transactional(readOnly = true)
    public List<CVDetailsListDto> getDetailsList(String username) {

        List<CVDetailsListDto> cvDetailsListDtos = new ArrayList<>();

        Member member = memberRepository.findByUsername(username);
        CVDetailsList cvDetailsList = cvDetailsListRepository.findByMemberId(member.getId());

        if (cvDetailsList == null) {
            return cvDetailsListDtos;
        }

        cvDetailsListDtos = cvDetailsRepository.findCVDetailsListDto(cvDetailsList.getId());
        return cvDetailsListDtos;
    }
}
