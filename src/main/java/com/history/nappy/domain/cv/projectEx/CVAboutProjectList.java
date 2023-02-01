package com.history.nappy.domain.cv.projectEx;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.cv.CV;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private CV cv;

    public static CVAboutProjectList createList(CV cv) {
        CVAboutProjectList cvAboutProjectList = new CVAboutProjectList();
        cvAboutProjectList.setCv(cv);
        return cvAboutProjectList;
    }
}
