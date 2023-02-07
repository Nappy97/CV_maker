package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.CV;
import com.history.nappy.dto.cv.CVFormDto;
import com.history.nappy.repository.cv.*;
import com.history.nappy.repository.cv.details.CVDetailsRepository;
import com.history.nappy.repository.cv.projectList.CVAboutProjectRepository;
import com.history.nappy.repository.cv.skills.CVSkillsRepository;
import com.history.nappy.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CVService {

    private final CVRepository cvRepository;
    private final CVDetailsRepository cvDetailsRepository;
    private final MemberRepository memberRepository;
    private final CVAboutProjectRepository cvAboutProjectRepository;
    private final CVSkillsRepository cvSkillsRepository;

}
