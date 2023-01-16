package com.history.nappy.repository.member;

import com.history.nappy.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);

    Member searchById(Long id);

    Optional<Member> findByProviderAndProviderId(String provider, String providerId);

    Optional<Member> searchByUsername(String username);

    boolean existsByUsername (String username);

    boolean existsByNickname(String nickname);

    boolean existsByEmail(String email);

}
