package com.toyproject.toyBulletin.dao;

import com.toyproject.toyBulletin.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class ArticleDto {
    private Long author;
    private String title;
    private String content;

    public ArticleDto(Long author, String title, String content){
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
