package com.history.nappy.domain.cv.aboutProject;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.cv.CVContent;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cv_about_project_list")
@Getter
@Setter
public class CVAboutProjectList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_about_project_list_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_about_project_id")
    private CVAboutProject cvAboutProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_content_id")
    private CVContent cvContent;

    public static CVAboutProjectList createCVAboutProjectList(CVContent cvContent, CVAboutProject cvAboutProject) {
        CVAboutProjectList cvAboutProjectList = new CVAboutProjectList();
        cvAboutProjectList.setCvContent(cvContent);
        cvAboutProjectList.setCvAboutProject(cvAboutProject);
        return cvAboutProjectList;
    }
}
