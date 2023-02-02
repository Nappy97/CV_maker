package com.history.nappy.repository.cv.projectList;

import com.history.nappy.domain.cv.projectList.CVAboutProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVAboutProjectRepository extends JpaRepository<CVAboutProject, Long>, CVAboutProjectCustom {

}
