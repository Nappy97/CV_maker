package com.history.nappy.repository.cv;

import com.history.nappy.domain.cv.projectEx.CVAboutProject;
import com.history.nappy.dto.cv.CVAboutProjectSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CVAboutProjectCustom {

    Page<CVAboutProject> getMainCVAboutProjectList(CVAboutProjectSearchDto cvAboutProjectSearchDto, Pageable pageable);

}
