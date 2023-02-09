package com.history.nappy.dto.cv;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CVContentDto {

    private Long memberId;
    private Long cvAboutProjectListId;
    private Long cvDetailsListId;
    private Long cvSkillsListId;
    private List<CVContentDto> cvContentDtoList;
}
