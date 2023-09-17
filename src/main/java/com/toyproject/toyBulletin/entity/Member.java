package com.toyproject.toyBulletin.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Column(nullable = false, unique = true)
    private String memberId;

    @Column(nullable = false)
    private String pw;

    public Member(String nickName, String memberId, String pw){
        this.nickName = nickName;
        this.memberId = memberId;
        this.pw = pw;
    }
}
