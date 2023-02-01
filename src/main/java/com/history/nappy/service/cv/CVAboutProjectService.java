package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.projectEx.CVAboutProject;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.CVAboutProjectDto;
import com.history.nappy.repository.cv.CVAboutProjectRepository;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
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
    public void saveCVAboutProject(CVAboutProjectDto cvAboutProjectDto,String username) throws IOException{

        Member member = memberRepository.findByUsername(username);
        CVAboutProject cvAboutProject = cvAboutProjectRepository.findByMemberId(member.getId());

        // 프로젝트모음이 존재하지 않는다면 생성
        if (cvAboutProject == null){
            cvAboutProject = CVAboutProject
        }
    }
}
