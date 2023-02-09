package com.history.nappy.domain.cv;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.cv.aboutProject.CVAboutProject;
import com.history.nappy.domain.cv.aboutProject.CVAboutProjectList;
import com.history.nappy.domain.cv.details.CVDetails;
import com.history.nappy.domain.cv.details.CVDetailsList;
import com.history.nappy.domain.cv.skills.CVSkills;
import com.history.nappy.domain.cv.skills.CVSkillsList;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "member_id")
    private Member member;

//    @OneToMany(mappedBy = "cvContent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<CVAboutProjectList> cvAboutProjectLists = new ArrayList<>();
//
//    @OneToMany(mappedBy = "cvContent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<CVDetailsList> cvDetailsLists = new ArrayList<>();
//
//    @OneToMany(mappedBy = "cvContent", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private List<CVSkillsList> cvSkillsLists = new ArrayList<>();
//
//    @Column(nullable = false, length = 100)
//    private String title;
//
//    public void addCVAboutProject(CVAboutProjectList cvAboutProjectList){
//        cvAboutProjectLists.add(cvAboutProjectList);
//        cvAboutProjectList.setCvContent(this);
//    }
//
//    public void addCVDetailsList(CVDetailsList cvDetailsList){
//        cvDetailsLists.add(cvDetailsList);
//        cvDetailsList.setCvContent(this);
//    }
//
//    public void addCVSkillsList(CVSkillsList cvSkillsList){
//        cvSkillsLists.add(cvSkillsList);
//        cvSkillsList.setCvContent(this);
//    }
//
//    public static CVContent createCV(Member member, List<CVAboutProjectList> cvAboutProjectLists,
//                                     List<CVDetailsList> cvDetailsLists, List<CVSkillsList> cvSkillsLists){
//        CVContent cvContent = new CVContent();
//        cvContent.setMember(member);
//        for (CVAboutProjectList cvAboutProjectList : cvAboutProjectLists) {
//            cvContent.addCVAboutProject(cvAboutProjectList);
//        }
//        for (CVDetailsList cvDetailsList : cvDetailsLists) {
//            cvContent.addCVDetailsList(cvDetailsList);
//        }
//        for (CVSkillsList cvSkillsList : cvSkillsLists) {
//            cvContent.addCVSkillsList(cvSkillsList);
//        }
//        cvContent.setTitle(member.getName() + "의 자기소개서");
//        return cvContent;
//    }

    public static CVContent createCVContent(Member member) {
        CVContent cvContent = new CVContent();
        cvContent.setMember(member);
        return cvContent;
    }

}
