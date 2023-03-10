package com.history.nappy.repository.cv.projectList;

import com.history.nappy.domain.cv.aboutProject.CVAboutProject;
import com.history.nappy.dto.cv.aboutProject.CVAboutProjectListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CVAboutProjectRepository extends JpaRepository<CVAboutProject, Long>, CVAboutProjectCustom {

//    CVAboutProject findByCvAboutProjectListIdAndId(Long cvAboutProjectListId, Long id);

    @Query("select new com.history.nappy.dto.cv.aboutProject.CVAboutProjectListDto(" +
            "ap.id, ap.title, ap.intro, ap.startedDate, ap.completionDate, ap.numOfMembers," +
            "ap.content, ap.takeaway, ap.references ) " +
            "from CVAboutProject ap " +
            "where ap.createdBy = :username " +
            "order by ap.createdDate desc")
    List<CVAboutProjectListDto> findCVAboutProjectListDto(@Param("username") String username);


}
