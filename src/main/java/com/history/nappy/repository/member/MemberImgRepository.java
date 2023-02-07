package com.history.nappy.repository.member;

import com.history.nappy.domain.member.MemberImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberImgRepository extends JpaRepository<MemberImg, Long> {

//    List<MemberImg> findByMemberIdOrderByIdAsc(Long memberId);

    MemberImg findByMemberId(Long MemberId);
}
