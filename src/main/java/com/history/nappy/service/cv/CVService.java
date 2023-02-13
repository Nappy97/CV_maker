package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.CVContent;
import com.history.nappy.domain.cv.aboutProject.CVAboutProject;
import com.history.nappy.domain.cv.aboutProject.CVAboutProjectList;
import com.history.nappy.domain.cv.details.CVDetails;
import com.history.nappy.domain.cv.details.CVDetailsList;
import com.history.nappy.domain.cv.skills.CVSkills;
import com.history.nappy.domain.cv.skills.CVSkillsList;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.CVContentDto;
import com.history.nappy.dto.cv.aboutProject.CVAboutProjectListDto;
import com.history.nappy.dto.cv.aboutProject.CVContentAboutProjectDto;
import com.history.nappy.dto.cv.details.CVContentDetailsDto;
import com.history.nappy.dto.cv.details.CVDetailsListDto;
import com.history.nappy.dto.cv.skills.CVContentSkillsDto;
import com.history.nappy.dto.cv.skills.CVSkillsListDto;
import com.history.nappy.repository.cv.*;
import com.history.nappy.repository.cv.details.CVDetailsListRepository;
import com.history.nappy.repository.cv.details.CVDetailsRepository;
import com.history.nappy.repository.cv.projectList.CVAboutProjectListRepository;
import com.history.nappy.repository.cv.projectList.CVAboutProjectRepository;
import com.history.nappy.repository.cv.skills.CVSkillsListRepository;
import com.history.nappy.repository.cv.skills.CVSkillsRepository;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
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
    private final CVDetailsListRepository cvDetailsListRepository;
    private final CVSkillsListRepository cvSkillsListRepository;

//    public Long makeCV(CVFormDto cvFormDto, String username) {
//
//        // CVAboutProjectList 생성
//        List<CVAboutProjectList> cvAboutProjectLists = new ArrayList<>();
//        CVAboutProject cvAboutProject = cvAboutProjectRepository.findById(cvFormDto.getCvAboutProjectId())
//                .orElseThrow(EntityNotFoundException::new);
//        cvAboutProjectLists.add(CVAboutProjectList.createCVAboutProjectList(cvAboutProject));
//
//        // CVDetailsList 생성
//        List<CVDetailsList> cvDetailsLists = new ArrayList<>();
//        CVDetails cvDetails = cvDetailsRepository.findById(cvFormDto.getCvDetailsId())
//                .orElseThrow(EntityNotFoundException::new);
//        cvDetailsLists.add(CVDetailsList.createCVDetailsList(cvDetails));
//
//        // CVSkillsList 생성
//        List<CVSkillsList> cvSkillsLists = new ArrayList<>();
//        CVSkills cvSkills = cvSkillsRepository.findById(cvFormDto.getCvSkillsId())
//                .orElseThrow(EntityNotFoundException::new);
//        cvSkillsLists.add(CVSkillsList.createCVSkillsList(cvSkills));
//
//        // CVContent 객체 생성
//        Member member = memberRepository.findByUsername(username);
//        CVContent cv = CVContent.createCV(member, cvAboutProjectLists, cvDetailsLists, cvSkillsLists);
//
//        // 객체 DB저장
//        cvContentRepository.save(cv);
//        return cv.getId();
//    }

    // CvAboutProject 담기
    public Long addCVAboutProject(CVAboutProjectListDto cvAboutProjectListDto, String username) {

        Member member = memberRepository.findByUsername(username);
        CVContent cvContent = cvContentRepository.findByMemberId(member.getId());

        // List가 존재합니까?
        if (cvContent == null) {
            cvContent = CVContent.createCVContent(member);
            cvContentRepository.save(cvContent);
        }

        CVAboutProject cvAboutProject = cvAboutProjectRepository.findById(cvAboutProjectListDto.getCvAboutProjectId())
                .orElseThrow(EntityExistsException::new);
        CVAboutProjectList cvAboutProjectList = cvAboutProjectListRepository
                .findByCvContentIdAndCvAboutProjectId(cvContent.getId(), cvAboutProject.getId());

        // list에 없을시에 생성 후 추가
        if (cvAboutProjectList == null) {
            cvAboutProjectList = CVAboutProjectList.createCVAboutProjectList(cvContent, cvAboutProject);
            cvAboutProjectListRepository.save(cvAboutProjectList);
        } else {
            return null;
        }
        return cvAboutProjectList.getId();
    }

    // CVDetails 담기
    public Long addCVDetails(CVDetailsListDto cvDetailsListDto, String username) {

        Member member = memberRepository.findByUsername(username);
        CVContent cvContent = cvContentRepository.findByMemberId(member.getId());

        // List가 존재합니까?
        if (cvContent == null) {
            cvContent = CVContent.createCVContent(member);
            cvContentRepository.save(cvContent);
        }

        CVDetails cvDetails = cvDetailsRepository.findById(cvDetailsListDto.getCvDetailsId())
                .orElseThrow(EntityExistsException::new);
        CVDetailsList cvDetailsList = cvDetailsListRepository
                .findByCvContentIdAndCvDetailsId(cvContent.getId(), cvDetails.getId());

        // list에 없을시에 생성 후 추가
        if (cvDetailsList == null) {
            cvDetailsList = CVDetailsList.createCVDetailsList(cvContent, cvDetails);
            cvDetailsListRepository.save(cvDetailsList);
        } else {
            return null;
        }
        return cvDetailsList.getId();
    }

    // CVSkills 담기
    public Long addCVSkills(CVSkillsListDto cvSkillsListDto, String username) {

        Member member = memberRepository.findByUsername(username);
        CVContent cvContent = cvContentRepository.findByMemberId(member.getId());

        // List가 존재합니까?
        if (cvContent == null) {
            cvContent = CVContent.createCVContent(member);
            cvContentRepository.save(cvContent);
        }

        CVSkills cvSkills = cvSkillsRepository.findById(cvSkillsListDto.getCvSkillsId())
                .orElseThrow(EntityExistsException::new);
        CVSkillsList cvSkillsList = cvSkillsListRepository
                .findByCvContentIdAndCvSkillsId(cvContent.getId(), cvSkills.getId());

        // list에 없을 시에 생성 후 추가
        if (cvSkillsList == null) {
            cvSkillsList = CVSkillsList.createCVSkillsList(cvContent, cvSkills);
            cvSkillsListRepository.save(cvSkillsList);
        } else {
            return null;
        }
        return cvSkillsList.getId();
    }

    // CV조회 * aboutProject
    @Transactional(readOnly = true)
    public List<CVContentAboutProjectDto> getCVContentAboutProjectList(String username) {

        List<CVContentAboutProjectDto> cvContentAboutProjectDtos = new ArrayList<>();

        Member member = memberRepository.findByUsername(username);
        CVContent cvContent = cvContentRepository.findByMemberId(member.getId());

        if (cvContent == null) {
            return cvContentAboutProjectDtos;
        }

        cvContentAboutProjectDtos = cvAboutProjectListRepository.findCVContentAboutProjectDto(cvContent.getId());
        return cvContentAboutProjectDtos;
    }

    // * detils
    @Transactional(readOnly = true)
    public List<CVContentDetailsDto> getCVContentDetailsList(String username) {

        List<CVContentDetailsDto> cvContentDetailsDtos = new ArrayList<>();

        Member member = memberRepository.findByUsername(username);
        CVContent cvContent = cvContentRepository.findByMemberId(member.getId());

        if (cvContent == null) {
            return cvContentDetailsDtos;
        }

        cvContentDetailsDtos = cvDetailsListRepository.findCVContentDetailsDto(cvContent.getId());
        return cvContentDetailsDtos;
    }

    // * skills
    @Transactional(readOnly = true)
    public List<CVContentSkillsDto> getCVContentSkillsList(String username) {

        List<CVContentSkillsDto> cvContentSkillsDtos = new ArrayList<>();

        Member member = memberRepository.findByUsername(username);
        CVContent cvContent = cvContentRepository.findByMemberId(member.getId());

        if (cvContent == null) {
            return cvContentSkillsDtos;
        }

        cvContentSkillsDtos = cvSkillsListRepository.findCVContentSkillsDto(cvContent.getId());
        return cvContentSkillsDtos;
    }

    // 완성
    public Long CVList(List<CVContentDto> cvContentDtoList, String username){

        List<>
    }
}
