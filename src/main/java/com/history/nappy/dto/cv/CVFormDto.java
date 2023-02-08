package com.history.nappy.dto.cv;

import com.history.nappy.domain.cv.CV;
import com.history.nappy.domain.cv.CVType;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CVFormDto {

    private Long id;

    private Long memberId;

    private Long cvAboutProjectId;

    private Long cvDetailsId;

    private Long cvSkillsId;

    private String title;

}
