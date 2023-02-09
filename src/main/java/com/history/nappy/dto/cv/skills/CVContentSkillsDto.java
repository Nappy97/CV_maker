package com.history.nappy.dto.cv.skills;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CVContentSkillsDto {

    private Long cvSkillsId;

    private String type;

    private String name;

    public CVContentSkillsDto(Long cvSkillsId, String type, String name) {
        this.cvSkillsId = cvSkillsId;
        this.type = type;
        this.name = name;
    }
}
