package com.history.nappy.repository.cv;

import com.history.nappy.domain.cv.CVImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CVImgRepository extends JpaRepository<CVImg, Long> {

    List<CVImg> findByCvId(Long cvId);

    CVImg findByCvIdAAndRepimgYn(Long cvId, String repimgYn);
}
