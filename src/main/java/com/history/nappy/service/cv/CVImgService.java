package com.history.nappy.service.cv;

import com.history.nappy.domain.cv.personalInfo.CVImg;
import com.history.nappy.repository.cv.CVImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class CVImgService {

    @Value("${cvImgLocation}")
    private String cvImgLocation;

    private final FileService fileService;

    private final CVImgRepository cvImgRepository;

    // 이미지 저장
    public void saveCVImg(CVImg cvImg, MultipartFile cvImgFile) throws IOException {
        String oriImgName = cvImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        // 파일 업로드
        if (!StringUtils.isEmpty(oriImgName)) {
            imgName = fileService.uploadFile(cvImgLocation, oriImgName, cvImgFile.getBytes());
            imgUrl = "/images/cv/" + imgName;
        }

        // 이미지 정보 저장
        cvImg.updateCVImg(oriImgName, imgName, imgUrl);
        cvImgRepository.save(cvImg);
    }

    // 이미지 수정
    public void updateCVImg(Long cvImgId, MultipartFile cvImgFile) throws IOException {

        // 수정
        if (!cvImgFile.isEmpty()) {
            CVImg savedCVImg = cvImgRepository.findById(cvImgId).orElseThrow(EntityNotFoundException::new);

            // 기존 이미지 존재식 삭제
            if (!StringUtils.isEmpty(savedCVImg.getImgName())) {
                fileService.deleteFile(cvImgLocation + "/" + savedCVImg);
            }

            String oriImgName = cvImgFile.getOriginalFilename();
            String imgName = fileService.uploadFile(cvImgLocation, oriImgName, cvImgFile.getBytes());
            String imgUrl = "/images/cv" + imgName;
            savedCVImg.updateCVImg(oriImgName, imgName, imgUrl);
        }
    }
}
