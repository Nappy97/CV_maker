package com.history.nappy.domain.cv;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.member.Member;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_about_project_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private CV cv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

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
}
