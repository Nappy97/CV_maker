package com.history.nappy.service.cv.personalInfo;

import com.history.nappy.repository.cv.personalInfo.CVImgRepository;
import com.history.nappy.repository.cv.personalInfo.CVPersonalInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CVPersonalInfoService {

    private final CVPersonalInfoRepository cvPersonalInfoRepository;
    private final CVImgRepository cvImgRepository;
    private final CVImgService cvImgService;

    public Long save
}
