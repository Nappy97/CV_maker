package com.history.nappy.dto.cv;

import com.history.nappy.domain.cv.CVDetails;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CVDetailsDto {

    @NotBlank(message = "제목을 입력해주세요!")
    private String title;

    @NotBlank(message = "내용을 입력해주세요!")
    private String content;

    private static ModelMapper modelMapper = new ModelMapper();

    // DTO -> Entity
    public CVDetails createCVDetails() {
        return modelMapper.map(this, CVDetails.class);
    }

    //Entity -> DTO
    public static CVDetailsDto of(CVDetails cvDetails) {
        return modelMapper.map(cvDetails, CVDetailsDto.class);
    }
}
