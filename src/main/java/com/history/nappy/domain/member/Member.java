package com.history.nappy.domain.member;

import com.history.nappy.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String username;    // 아이디

    @Column(nullable = false, length = 100)
    private String password;

    @Column(length = 30, unique = true)
    private String email;

    @Column(length = 20, unique = true)
    private String nickname;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private int zipcode;

    @Column(length = 200)
    private String address;

    @Column(length = 200)
    private String detailAddress;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column
    private String provider;

    @Column
    private String providerId;

    // 학력
    @Column
    private LocalDateTime educatedStart;

    @Column
    private LocalDateTime educatedEnd;

    @Column
    private String schoolName;

    @Column
    private String major;

    @Column
    private String graduationStatus;

    // 권한
    public String getRoleKey(){
        return this.role.getKey();
    }

    // password 암호화
    public void setPassword(String password){
        this.password = password;
    }

    // 회원수정 메소드
    public Member update(String password, String nickname, String name, int zipcode,
                         String address, String detailAddress, String email,
                         LocalDateTime educatedStart, LocalDateTime educatedEnd,
                         String schoolName, String major, String graduationStatus) {
        this.password = password;
        this.nickname = nickname;
        this.name = name;
        this.zipcode = zipcode;
        this.address = address;
        this.detailAddress = detailAddress;
        this.email = email;
        this.educatedStart = educatedStart;
        this.educatedEnd = educatedEnd;
        this.schoolName = schoolName;
        this.major = major;
        this.graduationStatus = graduationStatus;
        return this;
    }

    // oauth 회원수정
    public Member updateOauth(String nickname, String name, int zipcode, String address, String detailAddress,
                              LocalDateTime educatedStart, LocalDateTime educatedEnd,
                              String schoolName, String major, String graduationStatus){
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
        return this;
    }
}
