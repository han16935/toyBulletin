package com.toyproject.toyBulletin.dto;

import com.toyproject.toyBulletin.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class MemberDto {
    private Long id;
    private String nickName;
    private String memberId;
    private String pw;

    public MemberDto(String nickName, String memberId, String pw){
        this.nickName = nickName;
        this.memberId = memberId;
        this.pw = pw;
    }

    public MemberDto(String memberId, String pw){
        this.memberId = memberId;
        this.pw = pw;
    }

    public MemberDto(Long id, String pw){
        this.id = id;
        this.pw = pw;
    }

    public Member toMember(){
        return new Member(this.getNickName(), this.getMemberId(), this.getPw());
    }

    public static MemberDto toMemberDao(Member m){
        return new MemberDto(m.getNickName(), m.getMemberId(), m.getPw());
    }
}

