package com.history.nappy.dto.cv;

import com.history.nappy.domain.cv.CV;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CVAboutProjectDto {

    private Long id;
    private CV cv;
    private Member member;
    private String title;
    private String intro;
    private LocalDateTime startedDate;
    private LocalDateTime completionDate;
    private int numOfMembers;
    private String content;
    private String takeaway;
    private String references;
}
