package com.history.nappy.repository.cv.details;

import com.history.nappy.domain.cv.details.CVDetailsList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVDetailsListRepository extends JpaRepository<CVDetailsList, Long> {

    CVDetailsList findByMemberId(Long memberId);
}
