package com.history.nappy.repository.cv;

import com.history.nappy.domain.cv.projectEx.CVAboutProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVAboutProjectRepository extends JpaRepository<CVAboutProject, Long> {

    CVAboutProject findByMemberId(Long memberId);
}
