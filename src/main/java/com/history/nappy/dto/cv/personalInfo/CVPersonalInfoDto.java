package com.history.nappy.dto.cv.personalInfo;

import com.history.nappy.domain.cv.personalInfo.CVPersonalInfo;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CVPersonalInfoDto {

    private Long id;
    private Member member;
    private LocalDateTime educatedStart;
    private LocalDateTime educatedEnd;
    private String schoolName;
    private String major;
    private String graduationStatus;

    private static ModelMapper modelMapper = new ModelMapper();

    private List<CVImgDto> cvImgDtoList = new ArrayList<>();
    private List<Long> cvImgIds = new ArrayList<>();

    // DTO -> Entity
    public CVPersonalInfo createCVPersonalInfo() {
        return modelMapper.map(this, CVPersonalInfo.class);
    }

    // Entity -> DTO
    public static CVPersonalInfoDto of(CVPersonalInfo cvPersonalInfo) {
        return modelMapper.map(cvPersonalInfo, CVPersonalInfoDto.class);
    }
}
