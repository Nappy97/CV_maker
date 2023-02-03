package com.history.nappy.domain.cv.aboutProject;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.aboutProject.CVAboutProjectDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cv_about_project")
@Getter
@Setter
public class CVAboutProject extends BaseEntity {

    // 프로젝트 소개 (내가 했었던)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_about_project_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_about_project_list_id")
    private CVAboutProjectList cvAboutProjectList;

    @Column(nullable = false, length = 100)
    private String title;   // 프로젝트명

    @Lob
    private String intro;   // 짧게 소개

    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime startedDate;

    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime completionDate;

    private int numOfMembers;

    @Lob
    private String content;

    @Lob
    private String takeaway;    // 느낀점, 성장점

    @Lob
    private String references;  // 참고자료

    public static CVAboutProject createCVAboutProject(CVAboutProjectList cvAboutProjectList,
                                                      String title, String intro, LocalDateTime startedDate,
                                                      LocalDateTime completionDate, int numOfMembers,
                                                      String content, String takeaway, String references) {
        CVAboutProject cvAboutProject = new CVAboutProject();
        cvAboutProject.setCvAboutProjectList(cvAboutProjectList);;
        cvAboutProject.setTitle(title);
        cvAboutProject.setIntro(intro);
        cvAboutProject.setStartedDate(startedDate);
        cvAboutProject.setCompletionDate(completionDate);
        cvAboutProject.setNumOfMembers(numOfMembers);
        cvAboutProject.setContent(content);
        cvAboutProject.setTakeaway(takeaway);
        cvAboutProject.setReferences(references);

        return cvAboutProject;
    }

//    // 수정
//    public void updateCVAboutProject(CVAboutProjectDto cvAboutProjectDto) {
//        this.title = cvAboutProjectDto.getTitle();
//        this.intro = cvAboutProjectDto.getIntro();
//        this.startedDate = cvAboutProjectDto.getStartedDate();
//        this.completionDate = cvAboutProjectDto.getCompletionDate();
//        this.numOfMembers = cvAboutProjectDto.getNumOfMembers();
//        this.content = cvAboutProjectDto.getContent();
//        this.takeaway = cvAboutProjectDto.getTakeaway();
//        this.references = cvAboutProjectDto.getReferences();
//    }
}
