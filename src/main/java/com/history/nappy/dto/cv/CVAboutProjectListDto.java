package com.history.nappy.dto.cv;

import com.history.nappy.domain.cv.CV;
import com.history.nappy.domain.member.Member;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CVAboutProjectListDto {

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

    @QueryProjection
    public CVAboutProjectListDto(Long id, String title, String intro, LocalDateTime startedDate, LocalDateTime completionDate,
                                 int numOfMembers, String content, String takeaway, String references) {
        this.id = id;
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
