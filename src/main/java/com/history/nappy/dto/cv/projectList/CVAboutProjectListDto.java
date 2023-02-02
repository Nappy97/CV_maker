package com.history.nappy.dto.cv.projectList;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Lob;
import java.time.LocalDateTime;

@Getter
@Setter
public class CVAboutProjectListDto {

    private Long cvAboutProjectId;
    private String title;
    private String intro;
    private LocalDateTime startedDate;
    private LocalDateTime completionDate;
    private int numOfMembers;
    private String content;
    private String takeaway;
    private String references;

    public CVAboutProjectListDto(Long cvAboutProjectId, String title, String intro,
                                 LocalDateTime startedDate, LocalDateTime completionDate,
                                 int numOfMembers, String content, String takeaway, String references) {
        this.cvAboutProjectId = cvAboutProjectId;
        this.title = title;
        this.intro = intro;
        this.startedDate = startedDate;
        this.completionDate = completionDate;
        this.numOfMembers = numOfMembers;
        this.content = content;
        this.takeaway = takeaway;
        this.references = references;
    }
}
