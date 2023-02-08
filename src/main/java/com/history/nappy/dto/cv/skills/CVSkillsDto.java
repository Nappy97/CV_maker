package com.history.nappy.dto.cv.skills;

import com.history.nappy.domain.cv.aboutProject.CVAboutProject;
import com.history.nappy.domain.cv.skills.CVSkills;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.aboutProject.CVAboutProjectDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class CVSkillsDto {

    private String type;
    private String name;
    private Member member;

    private static ModelMapper modelMapper = new ModelMapper();

    // DTO -> Entity
    public CVSkills createCVSkills() {
        return modelMapper.map(this, CVSkills.class);
    }

    // Entity -> DTO
    public static CVSkillsDto of(CVSkills cvSkills) {
        return modelMapper.map(cvSkills, CVSkillsDto.class);
    }
}
