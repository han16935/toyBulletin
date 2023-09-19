package com.toyproject.toyBulletin.service;

import com.toyproject.toyBulletin.dao.MemberDao;
import com.toyproject.toyBulletin.entity.Member;
import com.toyproject.toyBulletin.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class JoinService {

    private MemberRepository memberRepository;
    public Member join(MemberDao m) throws IllegalStateException{
        // 1. MemberDao를 Member로 전환
        Member willBeSaved = m.toMember();
        // 1-1. 전환된 m 대해 nickName, memberId 중복 검사
        //      검사 통과 불가 시, IllegalStateException

        // 2. Member 저장

        Member result = memberRepository.save(willBeSaved);
        // 3. 1에서 만들어진 결과 반환
        return result;
    }

    public Member login(MemberDao m){
        Member willBeLogined = m.toMember();
        Member original = memberRepository.findByMemberId(willBeLogined.getMemberId());
        log.info(willBeLogined.toString());
        log.info(original.toString());
        if(original == null || !(willBeLogined.getPw().equals(original.getPw()) &&
                                 willBeLogined.getMemberId().equals(original.getMemberId())))
            return null;
        else return original;
    }
}
