package com.history.nappy.dto.cv.details;

import com.history.nappy.domain.cv.aboutProject.CVAboutProject;
import com.history.nappy.domain.cv.details.CVDetails;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.aboutProject.CVAboutProjectDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CVDetailsDto {

    private String title;

    private String content;

    private Member member;

    private static ModelMapper modelMapper = new ModelMapper();

    // DTO -> Entity
    public CVDetails createCVDetails() {
        return modelMapper.map(this, CVDetails.class);
    }

    // Entity -> DTO
    public static CVDetailsDto of(CVDetails cvDetails) {
        return modelMapper.map(cvDetails, CVDetailsDto.class);
    }
}
