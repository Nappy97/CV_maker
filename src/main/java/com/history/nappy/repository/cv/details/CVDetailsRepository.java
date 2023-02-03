package com.history.nappy.repository.cv.details;

import com.history.nappy.domain.cv.details.CVDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVDetailsRepository extends JpaRepository<CVDetails, Long>, CVDetailsCustom {
}
