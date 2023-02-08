package com.history.nappy.domain.cv.details;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.cv.CVContent;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_details_id")
    private CVDetails cvDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_content_id")
    private CVContent cvContent;

    public static CVDetailsList createCVDetailsList(CVDetails cvDetails) {
        CVDetailsList cvDetailsList = new CVDetailsList();
        cvDetailsList.setCvDetails(cvDetails);
//        cvDetailsList.setMember(member);
        return cvDetailsList;
    }
}
