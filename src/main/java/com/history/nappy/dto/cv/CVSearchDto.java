package com.history.nappy.dto.cv;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CVSearchDto {

    private String searchDateType;
    private String searchBy;
    private String searchQuery = "";
}
