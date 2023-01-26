package com.history.nappy.domain.cv;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.CVFormDto;
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

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    private CVType cvType;

    // 수정
    public void updateCv(CVFormDto cvFormDto) {
        this.name = cvFormDto.getName();
        this.cvType = cvFormDto.getCvType();
    }

}
