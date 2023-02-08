package com.history.nappy.domain.cv;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.cv.aboutProject.CVAboutProject;
import com.history.nappy.domain.cv.details.CVDetails;
import com.history.nappy.domain.cv.skills.CVSkills;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cv_content")
@Getter
@Setter
public class CVContent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cv_contet_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id")
    private CV cv;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_about_project_id")
    private CVAboutProject cvAboutProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_details_id")
    private CVDetails cvDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_skills_id")
    private CVSkills cvSkills;

    @Column(nullable = false, length = 100)
    private String name;

    public static CVContent createCVContent(CV cv, Member member, CVAboutProject cvAboutProject,
                                            CVDetails cvDetails, CVSkills cvSkills,
                                            String name) {

        CVContent cvContent = new CVContent();
        cvContent.setCv(cv);
        cvContent.setMember(member);
        cvContent.setCvAboutProject(cvAboutProject);
        cvContent.setCvDetails(cvDetails);
        cvContent.setCvSkills(cvSkills);
        cvContent.setName(name);
        return cvContent;
    }

}
