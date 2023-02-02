package com.history.nappy.dto.cv;

import com.history.nappy.domain.cv.CV;
import com.history.nappy.domain.cv.projectEx.CVAboutProject;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Getter
@Setter
public class CVAboutProjectDto {

    private Long id;
    private Member member;
    private String title;
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
}
