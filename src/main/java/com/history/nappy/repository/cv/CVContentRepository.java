package com.history.nappy.repository.cv;

import com.history.nappy.domain.cv.CVContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVContentRepository extends JpaRepository<CVContent, Long> {

    CVContent findByMemberId(Long memberId);

    CVContent findByCvIdAndMemberId(Long cvId, Long memberId);

    CVContent findByIdAndCvAboutProjectId(Long id, Long cvAboutProjectId);

    CVContent findByIdAndCvDetailsId(Long id, Long cvDetailsId);

    CVContent findByIdAndCvSkillsId(Long id, Long cvSkillsId);


}
