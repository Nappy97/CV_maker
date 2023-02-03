package com.history.nappy.dto.cv.details;

import com.history.nappy.domain.cv.details.CVDetails;
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

}
