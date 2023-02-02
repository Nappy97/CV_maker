package com.history.nappy.domain.cv.projectList;

import com.history.nappy.domain.BaseEntity;
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
    @JoinColumn(name = "member_id")
    private Member member;

    public static CVAboutProjectList createProjectList(Member member) {
        CVAboutProjectList cvAboutProjectList = new CVAboutProjectList();
        cvAboutProjectList.setMember(member);
        return cvAboutProjectList;
    }
}
