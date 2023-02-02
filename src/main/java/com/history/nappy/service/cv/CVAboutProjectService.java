package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.projectList.CVAboutProject;
import com.history.nappy.dto.cv.projectList.CVAboutProjectDto;
import com.history.nappy.dto.cv.CVSearchDto;
import com.history.nappy.repository.cv.projectList.CVAboutProjectRepository;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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
    public Page<CVAboutProject> getMainCVAboutProjectList(CVSearchDto cvSearchDto, Pageable pageable) {
        return cvAboutProjectRepository.getMainCVAboutProjectList(cvSearchDto, pageable);
    }

    // 수정
    public Long updateCVAboutProject(CVAboutProjectDto cvAboutProjectDto) {

        CVAboutProject cvAboutProject = cvAboutProjectRepository.findById(cvAboutProjectDto.getId()).orElseThrow(EntityNotFoundException::new);
        cvAboutProject.updateCVAboutProject(cvAboutProjectDto);

        return cvAboutProject.getId();
    }
}
