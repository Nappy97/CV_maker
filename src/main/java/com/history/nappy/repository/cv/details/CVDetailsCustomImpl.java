package com.history.nappy.repository.cv.details;

import com.history.nappy.domain.cv.details.CVDetails;
import com.history.nappy.domain.cv.details.QCVDetails;
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

public class CVDetailsCustomImpl implements CVDetailsCustom {

    private JPAQueryFactory queryFactory;

    public CVDetailsCustomImpl(EntityManager em) {
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

        return QCVDetails.cVDetails.createdDate.after(dateTime);
    }

    // 제목검색
    private BooleanExpression searchByTitleAndContentLike(String searchBy, String searchQuery) {
        if (StringUtils.equals("title", searchBy)) {
            return QCVDetails.cVDetails.title.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("content", searchBy)) {
            return QCVDetails.cVDetails.content.like("%" + searchQuery + "%");
        }
        return null;
    }

    // 작성자
    private BooleanExpression usernameLike(String username) {
        return QCVDetails.cVDetails.cvDetailsList.member.username.like(("%" + username + "%"));
    }

    @Override
    public Page<CVDetails> getMainCVDetailsList(CVSearchDto cvSearchDto, Pageable pageable, String username) {
        QueryResults<CVDetails> results = queryFactory
                .selectFrom(QCVDetails.cVDetails)
                .where(regDtsAfter(cvSearchDto.getSearchDateType()),
                        searchByTitleAndContentLike(cvSearchDto.getSearchBy(), cvSearchDto.getSearchQuery()),
                        usernameLike(username))
                .orderBy(QCVDetails.cVDetails.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        // 결과
        List<CVDetails> content = results.getResults();

        // count
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
