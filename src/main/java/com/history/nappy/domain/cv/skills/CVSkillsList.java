package com.history.nappy.domain.cv.skills;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.cv.CVContent;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cv_skills_list")
@Getter
@Setter
public class CVSkillsList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_skills_list_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_skills_id")
    private CVSkills cvSkills;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_content_id")
    private CVContent cvContent;

    public static CVSkillsList createCVSkillsList(CVContent cvContent, CVSkills cvSkills) {
        CVSkillsList cvSkillsList = new CVSkillsList();
        cvSkillsList.setCvContent(cvContent);
        cvSkillsList.setCvSkills(cvSkills);
//        cvSkillsList.setMember(member);
        return cvSkillsList;
    }
}
