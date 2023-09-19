package com.toyproject.toyBulletin.repository;

import com.toyproject.toyBulletin.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT * FROM MEMBER WHERE MEMBER_ID = :memberId", nativeQuery = true)
    Member findByMemberId(@Param("memberId") String memberId);

    @Query(value = "SELECT * FROM MEMBER WHERE NICK_NAME = :nickName", nativeQuery = true)
    Member findByMemberNickName(@Param("nickName") String nickName);
//    public boolean login(String memberId, String pw){
//        if(findByMemberId(memberId).equals(pw)) return true;
//        else return false;
//    }
}
