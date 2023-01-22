package com.history.nappy.domain.cv;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CVType {

    JAVA("JAVA", "자바"),
    PYTHON("PYTHON", "파이썬"),
    SPRINGFRAMEWORK("Spring Framework", "스프링 프레임워크"),
    AWS("AWS", "에이더블유에스"),
    GIT("GIT", "깃"),
    HTML("HTML", "에이치티엠엘"),
    JAVASCRIPT("JAVASCRIPT", "자바스크립트"),
    MySQL("MySQL", "마이에큐엘"),
    IOS("IOS", "아이오에스"),
    SQL("SQL", "에스큐엘");



    private final String key;
    private final String title;
}
