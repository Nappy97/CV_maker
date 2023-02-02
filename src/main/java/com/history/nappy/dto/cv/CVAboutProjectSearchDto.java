package com.history.nappy.dto.cv;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CVAboutProjectSearchDto {

    private String searchDateType;
    private String searchBy;
    private String searchQuery = "";
}
