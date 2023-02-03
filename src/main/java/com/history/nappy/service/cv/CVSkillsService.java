package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.skills.CVSkills;
import com.history.nappy.domain.cv.skills.CVSkillsList;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.skills.CVSkillsDto;
import com.history.nappy.dto.cv.skills.CVSkillsListDto;
import com.history.nappy.repository.cv.skills.CVSkillsListRepository;
import com.history.nappy.repository.cv.skills.CVSkillsRepository;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CVSkillsService {

    private final CVSkillsRepository cvSkillsRepository;
    private final CVSkillsListRepository cvSkillsListRepository;
    private final MemberRepository memberRepository;

    // 스킬 저장
    public Long saveCVSkills(CVSkillsDto cvSkillsDto, String username) {

        Member member = memberRepository.findByUsername(username);
        CVSkillsList cvSkillsList = cvSkillsListRepository.findByMemberId(member.getId());

        if (cvSkillsList == null) {
            cvSkillsList = CVSkillsList.createCVSkillsList(member);
            cvSkillsListRepository.save(cvSkillsList);
        }

        CVSkills cvSkills;
        cvSkills = CVSkills.createCVSkills(cvSkillsList, cvSkillsDto.getType(), cvSkillsDto.getName());
        cvSkillsRepository.save(cvSkills);

        return cvSkills.getId();
    }

    // 목록 조회
    @Transactional(readOnly = true)
    public List<CVSkillsListDto> getSkillsList(String username) {

        List<CVSkillsListDto> cvSkillsListDtos = new ArrayList<>();

        Member member = memberRepository.findByUsername(username);
        CVSkillsList cvSkillsList = cvSkillsListRepository.findByMemberId(member.getId());

        if (cvSkillsList == null) {
            return cvSkillsListDtos;
        }

        cvSkillsListDtos = cvSkillsRepository.findCVSkillsListDto(cvSkillsList.getId());
        return cvSkillsListDtos;
    }
}
