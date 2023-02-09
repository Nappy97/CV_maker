package com.history.nappy.repository.cv.skills;

import com.history.nappy.domain.cv.skills.CVSkillsList;
import com.history.nappy.dto.cv.aboutProject.CVContentAboutProjectDto;
import com.history.nappy.dto.cv.skills.CVContentSkillsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CVSkillsListRepository extends JpaRepository<CVSkillsList, Long> {

    CVSkillsList findByMemberId(Long memberId);

    CVSkillsList findByCvContentIdAndCvSkillsId(Long cvContentId, Long cvSkillsId);

    @Query("select new com.history.nappy.dto.cv.skills.CVContentSkillsDto(" +
            "s.id, s.type, s.name ) " +
            "from CVSkillsList sl " +
            "join sl.cvSkills s " +
            "where sl.cvContent.id = :cvContentId " +
            "order by s.createdDate desc ")
    List<CVContentSkillsDto> findCVContentSkillsDto(@Param("cvContentId") Long cvContentId);
}
