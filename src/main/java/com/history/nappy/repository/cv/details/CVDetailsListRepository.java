package com.history.nappy.repository.cv.details;

import com.history.nappy.domain.cv.details.CVDetailsList;
import com.history.nappy.dto.cv.details.CVContentDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CVDetailsListRepository extends JpaRepository<CVDetailsList, Long> {

    CVDetailsList findByMemberId(Long memberId);

    CVDetailsList findByCvContentIdAndCvDetailsId(Long cvContentId, Long cvDetailsId);

    @Query("select new com.history.nappy.dto.cv.details.CVContentDetailsDto(" +
            "d.id, d.title, d.content ) " +
            "from CVDetailsList dl " +
            "join dl.cvDetails d " +
            "where dl.cvContent.id = :cvContentId " +
            "order by d.createdDate desc ")
    List<CVContentDetailsDto> findCVContentDetailsDto(@Param("cvContentId") Long cvContentId);
}
