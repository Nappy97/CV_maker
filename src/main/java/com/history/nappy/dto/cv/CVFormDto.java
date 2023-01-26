package com.history.nappy.dto.cv;

import com.history.nappy.domain.cv.CVType;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CVFormDto {

    private Long id;

    private Member member;

    @NotBlank(message = "이름을 입력해주세요!")
    private String name;

    private CVType cvType;


}
