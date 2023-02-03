package com.history.nappy.domain.cv.details;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cv_details_list")
@Getter
@Setter
public class CVDetailsList extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_details_list_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static CVDetailsList createCVDetailsList(Member member) {
        CVDetailsList cvDetailsList = new CVDetailsList();
        cvDetailsList.setMember(member);
        return cvDetailsList;
    }
}
