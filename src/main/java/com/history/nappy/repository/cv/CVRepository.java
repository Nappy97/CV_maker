package com.history.nappy.repository.cv;

import com.history.nappy.domain.cv.CV;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVRepository extends JpaRepository<CV, Long> {

    CV findByMemberId(Long memberId);
}
