package com.toyproject.toyBulletin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member author;

    private String title;

    private String content;

    public Article(Member author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
