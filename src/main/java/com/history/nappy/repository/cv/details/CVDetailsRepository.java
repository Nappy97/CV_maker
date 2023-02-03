package com.history.nappy.repository.cv.details;

import com.history.nappy.domain.cv.details.CVDetails;
import com.history.nappy.dto.cv.details.CVDetailsListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CVDetailsRepository extends JpaRepository<CVDetails, Long>, CVDetailsCustom {

//    CVDetails findByCvDetailsListId(Long cvDetailsId);

    @Query("select new com.history.nappy.dto.cv.details.CVDetailsListDto(" +
            "d.id, d.title, d.content ) " +
            "from CVDetails d " +
            "where d.cvDetailsList.id = :cvDetailsListId " +
            "order by d.createdDate desc ")
    List<CVDetailsListDto> findCVDetailsListDto(@Param("cvDetailsListId") Long cvDetailsListId);
}
