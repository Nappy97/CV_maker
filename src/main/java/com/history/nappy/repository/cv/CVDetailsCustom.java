package com.history.nappy.repository.cv;

import com.history.nappy.domain.cv.CVDetails;
import com.history.nappy.dto.cv.CVSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CVDetailsCustom {

    Page<CVDetails> getMainCVDetailsList(CVSearchDto cvSearchDto, Pageable pageable);
}
