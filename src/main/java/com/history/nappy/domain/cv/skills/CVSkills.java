package com.history.nappy.domain.cv.skills;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.cv.aboutProject.CVAboutProjectList;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cv_skills")
@Getter
@Setter
public class CVSkills extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_skills_id")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "cv_skills_list_id")
//    private CVSkillsList cvSkillsList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String type;

    private String name;    // 스킬이름

    public static CVSkills createCVSkills(Member member,
                                          String type, String name) {
        CVSkills cvSkills = new CVSkills();
//        cvSkills.setCvSkillsList(cvSkillsList);
        cvSkills.setMember(member);
        cvSkills.setType(type);
        cvSkills.setName(name);
        return cvSkills;
    }

    public void updateCVSkills(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
