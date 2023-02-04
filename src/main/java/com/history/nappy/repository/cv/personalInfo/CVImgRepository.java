package com.history.nappy.repository.cv.personalInfo;

import com.history.nappy.domain.cv.personalInfo.CVImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CVImgRepository extends JpaRepository<CVImg, Long> {

    List<CVImg> findByCvPersonalInfoIdOrderByIdAsc(Long cvPersonalInfoId);

    CVImg findByCvPersonalInfoIdAndRepimgYn(Long cvPersonalInfoId, String repimgYn);
}
