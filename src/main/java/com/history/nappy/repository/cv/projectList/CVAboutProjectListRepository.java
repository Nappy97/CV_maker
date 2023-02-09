package com.history.nappy.repository.cv.projectList;

import com.history.nappy.domain.cv.aboutProject.CVAboutProject;
import com.history.nappy.domain.cv.aboutProject.CVAboutProjectList;
import com.history.nappy.dto.cv.aboutProject.CVContentAboutProjectDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CVAboutProjectListRepository extends JpaRepository<CVAboutProjectList, Long> {

//    CVAboutProjectList findByMemberId(Long memberId);

    CVAboutProjectList findByCvContentIdAndCvAboutProjectId(Long cvContentId, Long cvAboutProjectId);

    @Query("select new com.history.nappy.dto.cv.aboutProject.CVContentAboutProjectDto(" +
            "ap.id, ap.title, ap.intro, ap.startedDate, ap.completionDate, ap.numOfMembers, " +
            "ap.content, ap.takeaway, ap.references ) " +
            "from CVAboutProjectList apl " +
            "join apl.cvAboutProject ap " +
            "where apl.cvContent.id = :cvContentId " +
            "order by ap.createdDate desc ")
    List<CVContentAboutProjectDto> findCVContentAboutProjectDto(@Param("cvContentId") Long cvContentId);

}
