package com.history.nappy.repository.cv.projectList;

import com.history.nappy.domain.cv.aboutProject.CVAboutProjectList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVAboutProjectListRepository extends JpaRepository<CVAboutProjectList, Long> {

    CVAboutProjectList findByMemberId(Long memberId);
}
