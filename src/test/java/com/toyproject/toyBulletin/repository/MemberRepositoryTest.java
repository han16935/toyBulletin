package com.toyproject.toyBulletin.repository;

import com.toyproject.toyBulletin.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

     @Autowired
     private MemberRepository memberRepository;

     @Test
     @DisplayName("로그인 테스트")
     public void login(){
         // Given
         String memberId = "HAN1";
         String correctPw = "1Q2W3E4R!";
         String wrongPw = "1";

         // Then
         assertThat(memberRepository.findByMemberId(memberId)).isEqualTo(correctPw);
         assertThat(memberRepository.findByMemberId(memberId)).isNotEqualTo(wrongPw);
     }

     @Test
     @DisplayName("회원가입 테스트")
     public void join(){
         // Given
         Member willJoinMember = new Member("TEST", "TEST", "AAAA");
         // When
         Member joinedMember = memberRepository.save(willJoinMember);
         // Then
         assertThat(willJoinMember).isEqualTo(joinedMember);
     }
}