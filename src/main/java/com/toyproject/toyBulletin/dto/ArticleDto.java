package com.toyproject.toyBulletin.dto;

import lombok.Getter;
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
