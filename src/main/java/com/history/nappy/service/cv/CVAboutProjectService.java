package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.projectEx.CVAboutProject;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.CVAboutProjectDto;
import com.history.nappy.dto.cv.CVAboutProjectSearchDto;
import com.history.nappy.repository.cv.CVAboutProjectRepository;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class CVAboutProjectService {

    private final CVAboutProjectRepository cvAboutProjectRepository;
    private final MemberRepository memberRepository;

    // 프로젝트 내용 저장
    public Long saveCVAboutProject(CVAboutProjectDto cvAboutProjectDto, String username) {

        CVAboutProject cvAboutProject = cvAboutProjectDto.createCVAboutProject();
        cvAboutProjectRepository.save(cvAboutProject);

        return cvAboutProject.getId();
    }

    // 목록조회
    @Transactional(readOnly = true)
    public Page<CVAboutProject> getMainCVAboutProjectList(CVAboutProjectSearchDto cvAboutProjectSearchDto, Pageable pageable) {
        return cvAboutProjectRepository.getMainCVAboutProjectList(cvAboutProjectSearchDto, pageable);
    }
}
