package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.CV;
import com.history.nappy.domain.cv.CVContent;
import com.history.nappy.domain.cv.aboutProject.CVAboutProject;
import com.history.nappy.domain.cv.aboutProject.CVAboutProjectList;
import com.history.nappy.domain.cv.details.CVDetails;
import com.history.nappy.domain.cv.skills.CVSkills;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.CVFormDto;
import com.history.nappy.repository.cv.*;
import com.history.nappy.repository.cv.details.CVDetailsRepository;
import com.history.nappy.repository.cv.projectList.CVAboutProjectListRepository;
import com.history.nappy.repository.cv.projectList.CVAboutProjectRepository;
import com.history.nappy.repository.cv.skills.CVSkillsRepository;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CVService {

    private final CVRepository cvRepository;
    private final CVContentRepository cvContentRepository;
    private final CVDetailsRepository cvDetailsRepository;
    private final MemberRepository memberRepository;
    private final CVAboutProjectRepository cvAboutProjectRepository;
    private final CVAboutProjectListRepository cvAboutProjectListRepository;
    private final CVSkillsRepository cvSkillsRepository;

    public Long makeCV(CVFormDto cvFormDto, String username) {
        Member member = memberRepository.findByUsername(username);
        CV cv = cvRepository.findByMemberId(member.getId());

        // create
        if ()

        CVAboutProject cvAboutProject = cvAboutProjectRepository.findById(cvFormDto.getCvAboutProjectId()).orElseThrow(EntityExistsException::new);
        CVDetails cvDetails = cvDetailsRepository.findById(cvFormDto.getCvDetailsId()).orElseThrow(EntityExistsException::new);
        CVSkills cvSkills = cvSkillsRepository.findById(cvFormDto.getCvSkillsId()).orElseThrow(EntityExistsException::new);

        CVContent cvContent = cvContentRepository.findByCvIdAndMemberId(cv.getId(), member.getId());
        CVContent cvContentProject = cvContentRepository.findByIdAndCvAboutProjectId(cvFormDto.getId(), )

        if (cvContent == null){
            cvContent = CVContent.createCVContent(cv, member, cvAboutProject, cvDetails, cvSkills, cvFormDto.getTitle());
            cvContentRepository.save(cvContent);
        } else {
            return null;
        }
        return cvContent.getId();
    }

    // CV조회
    @Transactional(readOnly = true)
    public List<>

}
