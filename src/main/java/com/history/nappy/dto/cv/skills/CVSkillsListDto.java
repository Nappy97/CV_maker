package com.history.nappy.dto.cv.skills;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CVSkillsListDto {

    private Long cvSkillsId;
    private String type;
    private String name;

    public CVSkillsListDto(Long cvSkillsId, String type, String name) {
        this.cvSkillsId = cvSkillsId;
        this.type = type;
        this.name = name;
    }
}
