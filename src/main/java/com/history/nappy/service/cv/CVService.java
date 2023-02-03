package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.CV;
import com.history.nappy.domain.cv.CVImg;
import com.history.nappy.dto.cv.CVFormDto;
import com.history.nappy.repository.cv.*;
import com.history.nappy.repository.cv.details.CVDetailsRepository;
import com.history.nappy.repository.cv.projectList.CVAboutProjectRepository;
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
    private final CVImgRepository cvImgRepository;
    private final CVPersonalInfoRepository cvPersonalInfoRepository;
    private final CVSkillsRepository cvSkillsRepository;
    private final CVImgService cvImgService;

    public Long saveCV(CVFormDto cvFormDto, List<MultipartFile> cvImgFileList) throws Exception{

        CV cv = cvFormDto.createCV();
        cvRepository.save(cv);

        // 이미지 등록
        for (int i = 0; i<cvImgFileList.size(); i++){
            CVImg cvImg = new CVImg();
            cvImg.setCv(cv);
            if (i == 0){
                cvImg.setRepimgYn("Y");
            } else {
                cvImg.setRepimgYn("N");
            }
            cvImgService.saveCVImg(cvImg, cvImgFileList.get(i));
        }
        return cv.getId();
    }

}
