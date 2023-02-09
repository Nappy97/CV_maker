package com.history.nappy.dto.cv;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CVContentListDto {

//    // personal detail
//    private Long memberId;
//
//    private String name;
//
//    private String email;
//
//    private String address;
//
//    private String detailAddress;
//
//    private LocalDateTime educatedStart;
//
//    private LocalDateTime educatedEnd;
//
//    private String schoolName;
//
//    private String major;
//
//    private String graduationStatus;

//    private String imgUrl;

    // aboutProject
    private Long cvAboutProjectId;

    private String title;

    private String intro;

    private LocalDateTime startedDate;

    private LocalDateTime completionDate;

    private int numOfMembers;

    private String content;

    private String takeaway;    // 느낀점, 성장점

    private String references;  // 참고자료

    // details
    private Long cvDetailsId;

    private String detailTitle;

    private String detailContent;

    // skills
    private Long cvSkillsId;

    private String type;

    private String skillName;

    public CVContentListDto(Long cvAboutProjectId, String title, String intro, LocalDateTime startedDate,
                            LocalDateTime completionDate, int numOfMembers, String content,
                            String takeaway, String references, Long cvDetailsId,
                            String detailTitle, String detailContent, Long cvSkillsId,
                            String type, String skillName) {
        this.cvAboutProjectId = cvAboutProjectId;
        this.title = title;
        this.intro = intro;
        this.startedDate = startedDate;
        this.completionDate = completionDate;
        this.numOfMembers = numOfMembers;
        this.content = content;
        this.takeaway = takeaway;
        this.references = references;
        this.cvDetailsId = cvDetailsId;
        this.detailTitle = detailTitle;
        this.detailContent = detailContent;
        this.cvSkillsId = cvSkillsId;
        this.type = type;
        this.skillName = skillName;
    }
}
