package com.history.nappy.repository.cv;

import com.history.nappy.domain.cv.CVDetails;
import com.history.nappy.dto.cv.CVListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CVDetailsRepository extends JpaRepository<CVDetails, Long> {

    CVDetails findByCvId(Long cvId);

    @Query("select new com.history.nappy.dto.cv.CVListDto(cd.id, cd.title, cd.content) " +
            "from CVDetails cd " +
            "where cd.cv.id = :cvId " +
            "order by cd.createdDate desc ")
    List<CVListDto> findCvListDto(@Param("cvId") Long cvId);
}
