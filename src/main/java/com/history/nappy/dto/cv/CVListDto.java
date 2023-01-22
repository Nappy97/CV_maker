package com.history.nappy.dto.cv;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CVListDto {

    private Long cvDetailId;
    private String title;
    private String content;

    public CVListDto(Long cvDetailId, String title, String content) {
        this.cvDetailId = cvDetailId;
        this.title = title;
        this.content = content;
    }
}
