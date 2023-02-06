package com.history.nappy.service.member;

import com.history.nappy.domain.cv.personalInfo.CVImg;
import com.history.nappy.domain.member.Member;
import com.history.nappy.domain.member.MemberImg;
import com.history.nappy.repository.member.MemberImgRepository;
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
public class MemberImgService {

    @Value("${cvImgLocation}")
    private String memberImgLocation;

    private final MemberImgRepository memberImgRepository;
    private final FileService fileService;

    // 이미지 저장
    public void saveMemberImg(MemberImg memberImg, MultipartFile memberImgFile) throws IOException {
        String oriImgName = memberImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        if (!StringUtils.isEmpty(oriImgName)) {
            imgName = fileService.uploadFile(memberImgLocation, oriImgName, memberImgFile.getBytes());
            imgUrl = "/images/cv/" + imgName;
        }

        memberImg.updateCVImg(oriImgName, imgName, imgUrl);
        memberImgRepository.save(memberImg);
    }

    // 이미지 수정
    public void updateMemberImg(Long memberImgId, MultipartFile memberImgFile) throws IOException {

        // 수정
        if (!memberImgFile.isEmpty()) {
            MemberImg savedMemberImg = memberImgRepository.findById(memberImgId).
                    orElseThrow(EntityNotFoundException::new);

            // 기존 이미지 존재식 삭제
            if (!StringUtils.isEmpty(savedMemberImg.getImgName())) {
                fileService.deleteFile(memberImgLocation + "/" + savedMemberImg);
            }

            String oriImgName = memberImgFile.getOriginalFilename();
            String imgName = fileService.uploadFile(memberImgLocation, oriImgName, memberImgFile.getBytes());
            String imgUrl = "/images/cv" + imgName;
            savedMemberImg.updateCVImg(oriImgName, imgName, imgUrl);
        }
    }
}
