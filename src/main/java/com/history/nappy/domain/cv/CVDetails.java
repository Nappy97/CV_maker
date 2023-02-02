package com.history.nappy.domain.cv;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.member.Member;
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
    @Column(name = "cv_detail_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    public void updateCVDetails(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
