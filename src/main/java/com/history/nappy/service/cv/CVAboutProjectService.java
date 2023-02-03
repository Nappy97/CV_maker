package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.aboutProject.CVAboutProject;
import com.history.nappy.domain.cv.aboutProject.CVAboutProjectList;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.aboutProject.CVAboutProjectDto;
import com.history.nappy.dto.cv.CVSearchDto;
import com.history.nappy.dto.cv.aboutProject.CVAboutProjectListDto;
import com.history.nappy.repository.cv.projectList.CVAboutProjectListRepository;
import com.history.nappy.repository.cv.projectList.CVAboutProjectRepository;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CVAboutProjectService {

    private final CVAboutProjectRepository cvAboutProjectRepository;
    private final CVAboutProjectListRepository cvAboutProjectListRepository;
    private final MemberRepository memberRepository;

    // 프로젝트 내용 저장
    public Long saveCVAboutProject(CVAboutProjectDto cvAboutProjectDto, String username) {

        Member member = memberRepository.findByUsername(username);
        CVAboutProjectList cvAboutProjectList = cvAboutProjectListRepository.findByMemberId(member.getId());

        if (cvAboutProjectList == null) {
            cvAboutProjectList = CVAboutProjectList.createCVAboutProjectList(member);
            cvAboutProjectListRepository.save(cvAboutProjectList);
        }

        CVAboutProject cvAboutProject = cvAboutProjectRepository.findByCvAboutProjectListId(cvAboutProjectList.getId());

        cvAboutProject = CVAboutProject.createCVAboutProject(cvAboutProjectList, cvAboutProjectDto.getTitle(),
                cvAboutProjectDto.getIntro(), cvAboutProjectDto.getStartedDate(), cvAboutProjectDto.getCompletionDate(),
                cvAboutProjectDto.getNumOfMembers(), cvAboutProjectDto.getContent(), cvAboutProjectDto.getTakeaway(),
                cvAboutProjectDto.getReferences());
        cvAboutProjectRepository.save(cvAboutProject);

        return cvAboutProject.getId();
    }

    // 목록조회
    @Transactional(readOnly = true)
    public List<CVAboutProjectListDto> getProjectList(String username) {

        List<CVAboutProjectListDto> cvAboutProjectListDtos = new ArrayList<>();

        Member member = memberRepository.findByUsername(username);
        CVAboutProjectList cvAboutProjectList = cvAboutProjectListRepository.findByMemberId(member.getId());

        if (cvAboutProjectList == null) {
            return cvAboutProjectListDtos;
        }

        cvAboutProjectListDtos = cvAboutProjectRepository.findCVAboutProjectListDto(cvAboutProjectList.getId());
        return cvAboutProjectListDtos;
    }


}
