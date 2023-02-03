package com.history.nappy.dto.cv;

import com.history.nappy.domain.cv.CVPersonalInfo;
import com.history.nappy.domain.member.Member;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

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

    // DTO -> Entity
    public CVPersonalInfo createCVPersonalInfo() {
        return modelMapper.map(this, CVPersonalInfo.class);
    }

    // Entity -> DTO
    public static CVPersonalInfoDto of(CVPersonalInfo cvPersonalInfo) {
        return modelMapper.map(cvPersonalInfo, CVPersonalInfoDto.class);
    }
}
