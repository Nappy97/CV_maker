package com.history.nappy.repository.cv.projectList;

import com.history.nappy.domain.cv.CVAboutProject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CVAboutProjectRepository extends JpaRepository<CVAboutProject, Long>, CVAboutProjectCustom {

    @Query("select ap from CVAboutProject ap " +
            "where ap.member.username = :username " +
            "order by ap.createdDate desc ")
    List<CVAboutProject> findCVAboutProject(@Param("username") String username, Pageable pageable);

    @Query("select count(ap) from CVAboutProject ap " +
            "where ap.member.username = :username ")
    Long countOrder(@Param("username") String username);

}
