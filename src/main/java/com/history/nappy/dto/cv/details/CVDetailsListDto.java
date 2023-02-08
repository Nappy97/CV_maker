package com.history.nappy.dto.cv.details;

import com.history.nappy.domain.cv.details.CVDetailsList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CVDetailsListDto {

    private String title;
    private String content;

    public CVDetailsListDto(CVDetailsList cvDetailsList) {
        this.title = cvDetailsList.getCvDetails().getTitle();
        this.content = cvDetailsList.getCvDetails().getContent();
    }
}
