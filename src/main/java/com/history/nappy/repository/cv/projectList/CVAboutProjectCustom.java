package com.history.nappy.repository.cv.projectList;

import com.history.nappy.domain.cv.CVAboutProject;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.CVSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CVAboutProjectCustom {

    Page<CVAboutProject> getMainCVAboutProjectList(CVSearchDto cvSearchDto, Pageable pageable, String username);

}
