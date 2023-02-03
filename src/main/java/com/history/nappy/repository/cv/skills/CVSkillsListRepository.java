package com.history.nappy.repository.cv.skills;

import com.history.nappy.domain.cv.skills.CVSkillsList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVSkillsListRepository extends JpaRepository<CVSkillsList, Long> {

    CVSkillsList findByMemberId(Long memberId);
}
