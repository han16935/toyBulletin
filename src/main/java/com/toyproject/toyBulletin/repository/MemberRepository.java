package com.toyproject.toyBulletin.repository;

import com.toyproject.toyBulletin.entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT * FROM MEMBER WHERE MEMBER_ID = :memberId", nativeQuery = true)
    Member findByMemberId(@Param("memberId") String memberId);

    @Query(value = "SELECT * FROM MEMBER WHERE NICK_NAME = :nickName", nativeQuery = true)
    Member findByMemberNickName(@Param("nickName") String nickName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE MEMBER SET IS_VALID = TRUE WHERE ID = :id", nativeQuery = true)
    void login(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE MEMBER SET IS_VALID = FALSE WHERE ID = :id", nativeQuery = true)
    void logout(@Param("id") Long id);
}
