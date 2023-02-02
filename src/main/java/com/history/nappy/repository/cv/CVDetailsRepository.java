package com.history.nappy.repository.cv;

import com.history.nappy.domain.cv.CVDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVDetailsRepository extends JpaRepository<CVDetails, Long>, CVDetailsCustom {
}
