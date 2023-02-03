package com.history.nappy.domain.cv;

import com.history.nappy.domain.BaseEntity;
import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.cv.CVPersonalInfoDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cv_personal_info")
@Getter
@Setter
public class CVPersonalInfo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_personal_info_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // 학력
    private LocalDateTime educatedStart;

    private LocalDateTime educatedEnd;

    private String schoolName;

    private String major;

    private String graduationStatus;

    // 수정
    public void updateCVPersonalInfo(CVPersonalInfoDto cvPersonalInfoDto) {
        this.educatedStart = cvPersonalInfoDto.getEducatedStart();
        this.educatedEnd = cvPersonalInfoDto.getEducatedEnd();
        this.schoolName = cvPersonalInfoDto.getSchoolName();
        this.major = cvPersonalInfoDto.getMajor();
        this.graduationStatus = cvPersonalInfoDto.getGraduationStatus();
    }
}
