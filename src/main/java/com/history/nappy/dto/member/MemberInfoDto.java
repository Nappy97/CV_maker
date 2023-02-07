package com.history.nappy.dto.member;

import com.history.nappy.domain.member.Role;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
public class MemberInfoDto {

    private Long id;

    private String username;

    private String email;

    private String nickname;

    private String name;

    private int zipcode;

    private String address;

    private String detailAddress;

    private LocalDateTime educatedStart;

    private LocalDateTime educatedEnd;

    private String schoolName;

    private String major;

    private String graduationStatus;

    private String imgUrl;

    @QueryProjection
    public MemberInfoDto(Long id, String username, String email, String nickname,
                         String name, int zipcode, String address, String detailAddress,
                         LocalDateTime educatedStart, LocalDateTime educatedEnd,
                         String schoolName, String major, String graduationStatus,
                         String imgUrl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.name = name;
        this.zipcode = zipcode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.educatedStart = educatedStart;
        this.educatedEnd = educatedEnd;
        this.schoolName = schoolName;
        this.major = major;
        this.graduationStatus = graduationStatus;
        this.imgUrl = imgUrl;
    }
}
