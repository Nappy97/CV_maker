package com.history.nappy.dto.cv.details;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CVContentDetailsDto {

    private Long cvDetailsId;

    private String title;

    private String content;

    public CVContentDetailsDto(Long cvDetailsId, String title, String content) {
        this.cvDetailsId = cvDetailsId;
        this.title = title;
        this.content = content;
    }
}
