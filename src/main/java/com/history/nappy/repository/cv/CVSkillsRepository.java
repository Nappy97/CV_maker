package com.history.nappy.repository.cv;

import com.history.nappy.domain.cv.skills.CVSkills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVSkillsRepository extends JpaRepository<CVSkills, Long> {
}
