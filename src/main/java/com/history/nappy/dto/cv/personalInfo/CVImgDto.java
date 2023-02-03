package com.history.nappy.dto.cv.personalInfo;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class CVImgDto {

    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;

    private static ModelMapper modelMapper = new ModelMapper();

    // Entity -> DTO
//    public static CVImgDto of(CVImg cvImg) {
//        return modelMapper.map(cvImg, CVImgDto.modelMapper);
//    }
}
