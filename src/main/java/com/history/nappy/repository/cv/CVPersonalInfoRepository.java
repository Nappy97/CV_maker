package com.history.nappy.repository.cv;

import com.history.nappy.domain.cv.personalInfo.CVPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVPersonalInfoRepository extends JpaRepository<CVPersonalInfo, Long> {
}
