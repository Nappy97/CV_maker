package com.history.nappy.dto.cv;

import com.history.nappy.domain.cv.CVSkills;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class CVSkillsDto {

    private Long id;
    private Member member;
    private String type;
    private String name;

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
