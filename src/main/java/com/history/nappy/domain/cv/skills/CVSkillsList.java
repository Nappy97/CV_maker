package com.history.nappy.domain.cv.skills;

import com.history.nappy.domain.BaseEntity;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static CVSkillsList createCVSkillsList(Member member) {
        CVSkillsList cvSkillsList = new CVSkillsList();
        cvSkillsList.setMember(member);
        return cvSkillsList;
    }
}
