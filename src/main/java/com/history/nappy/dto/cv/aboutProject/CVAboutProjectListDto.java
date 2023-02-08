package com.history.nappy.dto.cv.aboutProject;

import com.history.nappy.domain.cv.aboutProject.CVAboutProjectList;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CVAboutProjectListDto {

    private String title;
    private String intro;
    private LocalDateTime startedDate;
    private LocalDateTime completionDate;
    private int numOfMembers;
    private String content;
    private String takeaway;
    private String references;

    public CVAboutProjectListDto(CVAboutProjectList cvAboutProjectList) {
        this.title = cvAboutProjectList.getCvAboutProject().getTitle();
        this.intro = cvAboutProjectList.getCvAboutProject().getIntro();
        this.startedDate = cvAboutProjectList.getCvAboutProject().getStartedDate();
        this.completionDate = cvAboutProjectList.getCvAboutProject().getCompletionDate();
        this.numOfMembers = cvAboutProjectList.getCvAboutProject().getNumOfMembers();
        this.content = cvAboutProjectList.getCvAboutProject().getContent();
        this.takeaway = cvAboutProjectList.getCvAboutProject().getTakeaway();
        this.references = cvAboutProjectList.getCvAboutProject().getReferences();
    }
}
