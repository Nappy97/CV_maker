package com.history.nappy.repository.cv.projectList;

import com.history.nappy.domain.cv.aboutProject.CVAboutProject;
//import com.history.nappy.domain.cv.QCVAboutProject;
import com.history.nappy.domain.cv.aboutProject.QCVAboutProject;
import com.history.nappy.dto.cv.CVSearchDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class CVAboutProjectCustomImpl implements CVAboutProjectCustom {

    private JPAQueryFactory queryFactory;

    // 생성자 DI를 통해서 JPAQueryFactory(EntityManager) 주입
    public CVAboutProjectCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    // 등록일에 대한 조회조건
    private BooleanExpression regDtsAfter(String searchDateType) {
        LocalDateTime dateTime = LocalDateTime.now();
        if (StringUtils.equals("all", searchDateType) || searchDateType == null) {
            return null;
        } else if (StringUtils.equals("1d", searchDateType)) {
            dateTime = dateTime.minusDays(1);
        } else if (StringUtils.equals("1w", searchDateType)) {
            dateTime = dateTime.minusWeeks(1);
        } else if (StringUtils.equals("1m", searchDateType)) {
            dateTime = dateTime.minusMonths(1);
        } else if (StringUtils.equals("6m", searchDateType)) {
            dateTime = dateTime.minusMonths(6);
        }

        return QCVAboutProject.cVAboutProject.createdDate.after(dateTime);
    }

    // 제목검색
    private BooleanExpression searchByTitleLike(String searchQuery) {
        return QCVAboutProject.cVAboutProject.title.like("%" + searchQuery + "%");
    }

    // 작성자
    private BooleanExpression usernameLike(String username) {
        return QCVAboutProject.cVAboutProject.cvAboutProjectList.member.username.like(("%" + username + "%"));
    }

    @Override
    public Page<CVAboutProject> getMainCVAboutProjectList(CVSearchDto cvSearchDto, Pageable pageable, String username) {
        QueryResults<CVAboutProject> results = queryFactory
                .selectFrom(QCVAboutProject.cVAboutProject)
                .where(regDtsAfter(cvSearchDto.getSearchDateType()),
                        searchByTitleLike(cvSearchDto.getSearchQuery()),
                        usernameLike(username))
                .orderBy(QCVAboutProject.cVAboutProject.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        // 결과
        List<CVAboutProject> content = results.getResults();

        // count
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }

}
