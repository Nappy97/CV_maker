package com.history.nappy.domain.cv.details;

import com.history.nappy.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cv_detail")
@Getter
@Setter
public class CVDetails extends BaseEntity {

    // 자기소개
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cv_details_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_details_list_id")
    private CVDetailsList cvDetailsList;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    public static CVDetails createCVDetails(CVDetailsList cvDetailsList,
                                            String title, String content) {
        CVDetails cvDetails = new CVDetails();
        cvDetails.setCvDetailsList(cvDetailsList);
        cvDetails.setTitle(title);
        cvDetails.setContent(content);

        return cvDetails;
    }

    public void updateCVDetails(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
