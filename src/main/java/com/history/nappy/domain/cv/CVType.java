package com.history.nappy.domain.cv;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CVType {

    CODER("CV_CODER", "프로그래머"),


    private final String key;
    private final String title;
}
