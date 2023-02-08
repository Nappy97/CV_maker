package com.history.nappy.dto.cv.skills;

import com.history.nappy.domain.cv.skills.CVSkillsList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CVSkillsListDto {

    private String type;
    private String name;

    public CVSkillsListDto(CVSkillsList cvSkillsList) {
        this.type = cvSkillsList.getCvSkills().getType();
        this.name = cvSkillsList.getCvSkills().getName();
    }
}
