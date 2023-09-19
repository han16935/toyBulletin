package com.toyproject.toyBulletin.dao;

import com.toyproject.toyBulletin.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class MemberDao {
    private Long id;
    private String nickName;
    private String memberId;
    private String pw;

    public MemberDao(String nickName, String memberId, String pw){
        this.nickName = nickName;
        this.memberId = memberId;
        this.pw = pw;
    }

    public Member toMember(){
        return new Member(this.getNickName(), this.getMemberId(), this.getPw());
    }

    public static MemberDao toMemberDao(Member m){
        return new MemberDao(m.getNickName(), m.getMemberId(), m.getPw());
    }
}
