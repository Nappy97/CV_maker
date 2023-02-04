package com.history.nappy.dto.member;

import com.history.nappy.domain.member.Member;
import com.history.nappy.domain.member.Role;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class MemberDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class RequestMemberDto {

        private Long id;

        @NotBlank(message = "아이디는 필수 입니다.")
        @Length(min = 4, max = 16, message = "아이디는 4자 이상 16자 이하로 입력해주세요")
        @Pattern(regexp = "^[a-z0-9]{4,20}$", message = "아이디는 영어 소문자와 숫자만 사용하여 4~20자리여야 합니다.")
        private String username;

        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$", message = "비밀번호는 8~16자리수여야 합니다. 영문 대소문자, 숫자, 특수문자를 1개 이상 포함해야 합니다.")
        private String password;

        @NotBlank(message = "이메일은 필수 입력 값 입니다")
        @Email(message = "이메일 형식으로 입력해주세요")
        private String email;

        @NotBlank(message = "닉네임은 필수 입력 값입니다")
        @Length(min = 2, message = "닉네임은 2자 이상 입력해주세요")
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

        private Role role;

        public void encryptPassword(String BCryptPassword) {
            this.password = BCryptPassword;
        }

        public Member toEntity() {
            Member member = Member.builder()
                    .id(id)
                    .username(username)
                    .password(password)
                    .email(email)
                    .nickname(nickname)
                    .zipcode(zipcode)
                    .address(address)
                    .detailAddress(detailAddress)
                    .name(name)
                    .educatedStart(educatedStart)
                    .educatedEnd(educatedEnd)
                    .major(major)
                    .graduationStatus(graduationStatus)
                    .role(Role.USER)
                    .build();

            return member;
        }

    }
}
