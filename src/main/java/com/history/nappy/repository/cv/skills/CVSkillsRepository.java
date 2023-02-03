package com.history.nappy.repository.cv.skills;

import com.history.nappy.domain.cv.skills.CVSkills;
import com.history.nappy.dto.cv.skills.CVSkillsListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CVSkillsRepository extends JpaRepository<CVSkills, Long> {

    @Query("select new com.history.nappy.dto.cv.skills.CVSkillsListDto(" +
            "s.id, s.type, s.name ) " +
            "from CVSkills s " +
            "where s.cvSkillsList.id = :cvSkillsListId " +
            "order by s.createdDate desc ")
    List<CVSkillsListDto> findCVSkillsListDto(@Param("cvSkillsListId") Long cvSkillsListId);
}
