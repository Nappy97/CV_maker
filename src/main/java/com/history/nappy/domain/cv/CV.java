package com.history.nappy.domain.cv;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cv")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CV extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CVContent> cvContents = new ArrayList<>();

    public void addCVContent(CVContent cvContent){
        cvContents.add(cvContent);
        cvContent.setCv(this);
    }

    public static CV createCV(Member member, List<CVContent> cvContentsList){
        CV cv = new CV();
        cv.setMember(member);
        for (CVContent cvContent : cvContentsList) {
            cv.addCVContent(cvContent);
        }
        return cv;
    }

}
