package com.history.nappy.repository.member;

import com.history.nappy.domain.member.Member;
import com.history.nappy.dto.member.MemberInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);

    Member searchById(Long id);

    Optional<Member> findByProviderAndProviderId(String provider, String providerId);

    Optional<Member> searchByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByNickname(String nickname);

    boolean existsByEmail(String email);

    @Query("select new com.history.nappy.dto.member.MemberInfoDto(" +
            "m.id, m.username, m.email, m.nickname, m.name, m.zipcode, m.address, " +
            "m.detailAddress, m.educatedStart, m.educatedEnd, m.schoolName, " +
            "m.major, m.graduationStatus, mi.imgUrl ) " +
            "from Member m, MemberImg mi " +
            "join mi.member m1 " +
            "where m.id = :memberId " +
            "and mi.member.id = m.id ")
    MemberInfoDto findMemberInfoDto(@Param("memberId") Long memberId);
}
