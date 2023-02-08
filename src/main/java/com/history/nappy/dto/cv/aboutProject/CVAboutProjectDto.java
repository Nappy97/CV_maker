package com.history.nappy.dto.cv.aboutProject;

import com.history.nappy.domain.cv.aboutProject.CVAboutProject;
import com.history.nappy.domain.member.Member;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter
@Setter
public class CVAboutProjectDto {

    private String title;
    private Member member;
    private String intro;
    private LocalDateTime startedDate;
    private LocalDateTime completionDate;
    private int numOfMembers;
    private String content;
    private String takeaway;
    private String references;

    private static ModelMapper modelMapper = new ModelMapper();

    // DTO -> Entity
    public CVAboutProject createCVAboutProject() {
        return modelMapper.map(this, CVAboutProject.class);
    }

    // Entity -> DTO
    public static CVAboutProjectDto of(CVAboutProject cvAboutProject) {
        return modelMapper.map(cvAboutProject, CVAboutProjectDto.class);
    }

}
